package security;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.encryption.EncryptedData;
import org.apache.xml.security.encryption.EncryptedKey;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.encryption.XMLEncryptionException;
import org.apache.xml.security.keys.KeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import util.FilePaths;

//Generise tajni kljuc
//Kriptije sadrzaj elementa student tajnim kljucem
//Kriptuje tajni kljuc javnim kljucem
//Kriptovani tajni kljuc se stavlja kao KeyInfo kriptovanog elementa
public class EncryptKEK {
	
	private  String IN_FILE = "./xml/akt.xml";
	private  String OUT_FILE = "./xml/akt_enc.xml";
	private static final  String KEY_STORE_FILE = FilePaths.keystores+"primer.jks";
	public  String pass;
	
    static {
    	//staticka inicijalizacija
        Security.addProvider(new BouncyCastleProvider());
        org.apache.xml.security.Init.init();
    }
	
	public void testIt() {
		//ucitava se dokument
		Document doc = loadDocument(IN_FILE);
		//generise tajni kljuc
		System.out.println("Generating secret key ....");
		SecretKey secretKey = generateDataEncryptionKey();
		//ucitava sertifikat za kriptovanje tajnog kljuca
		Certificate cert = readCertificate();
		//kriptuje se dokument
		System.out.println("Encrypting....");
		doc = encrypt(doc ,secretKey, cert);
		//snima se tajni kljuc
		//snima se dokument
		saveDocument(doc, OUT_FILE);
		System.out.println("Encryption done");
	}
	
	/**
	 * Kreira DOM od XML dokumenta
	 */
	private Document loadDocument(String file) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new File(file));

			return document;
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
			return null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Ucitava sertifikat is KS fajla
	 * alias primer
	 */
	private Certificate readCertificate() {
		try {
			//kreiramo instancu KeyStore
			KeyStore ks = KeyStore.getInstance("JKS", "SUN");
			//ucitavamo podatke
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(KEY_STORE_FILE));
			ks.load(in, "primer".toCharArray());
			
			if(ks.isKeyEntry("primer")) {
				Certificate cert = ks.getCertificate("primer");
				return cert;
				
			}
			else
				return null;
			
		} catch (KeyStoreException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (CertificateException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 * Snima DOM u XML fajl 
	 */
	private void saveDocument(Document doc, String fileName) {
		try {
			File outFile = new File(fileName);
			FileOutputStream f = new FileOutputStream(outFile);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			
			transformer.transform(source, result);

			f.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generise tajni kljuc
	 */
	private SecretKey generateDataEncryptionKey() {

        try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede"); //Triple DES
			return keyGenerator.generateKey();
		
        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	/**
	 * Kriptuje sadrzaj prvog elementa odsek
	 */
	private Document encrypt(Document doc, SecretKey key, Certificate certificate) {
		
		try {
			//cipher za kriptovanje tajnog kljuca,
			//Koristi se Javni RSA kljuc za kriptovanje
			XMLCipher keyCipher = XMLCipher.getInstance(XMLCipher.RSA_v1dot5);
		      //inicijalizacija za kriptovanje tajnog kljuca javnim RSA kljucem
		    keyCipher.init(XMLCipher.WRAP_MODE, certificate.getPublicKey());
		    EncryptedKey encryptedKey = keyCipher.encryptKey(doc, key);
			
		    //cipher za kriptovanje XML-a
		    XMLCipher xmlCipher = XMLCipher.getInstance(XMLCipher.TRIPLEDES);
		    //inicijalizacija za kriptovanje
		    xmlCipher.init(XMLCipher.ENCRYPT_MODE, key);
		    
		    //u EncryptedData elementa koji se kriptuje kao KeyInfo stavljamo kriptovan tajni kljuc
		    EncryptedData encryptedData = xmlCipher.getEncryptedData();
	        //kreira se KeyInfo
		    KeyInfo keyInfo = new KeyInfo(doc);
		    keyInfo.addKeyName("Kriptovani tajni kljuc");
	        //postavljamo kriptovani kljuc
		    keyInfo.add(encryptedKey);
		    //postavljamo KeyInfo za element koji se kriptuje
	        encryptedData.setKeyInfo(keyInfo);
			
			//trazi se element ciji sadrzaj se kriptuje
			NodeList odseci = doc.getElementsByTagName("Lozinka");
			Element odsek = (Element) odseci.item(0);
			
			xmlCipher.doFinal(doc, odsek, true); //kriptuje sa sadrzaj
			
			return doc;
			
		} catch (XMLEncryptionException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		EncryptKEK encrypt = new EncryptKEK();
	//	encrypt.testIt();
	}
	
	
	public String getIN_FILE() {
		return IN_FILE;
	}

	public void setIN_FILE(String iN_FILE) {
		IN_FILE = iN_FILE;
	}

	public String getOUT_FILE() {
		return OUT_FILE;
	}

	public void setOUT_FILE(String oUT_FILE) {
		OUT_FILE = oUT_FILE;
	}

	/*public String getKEY_STORE_FILE() {
		return KEY_STORE_FILE;
	}

	public void setKEY_STORE_FILE(String kEY_STORE_FILE) {
		KEY_STORE_FILE = kEY_STORE_FILE;
	}
	
    public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}*/

	
}