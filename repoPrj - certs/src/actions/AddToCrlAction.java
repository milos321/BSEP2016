package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import form.AddToCrlForm;
import form.ExportForm;
import security.KeyStoreWriter;

public class AddToCrlAction extends AbstractAction {
	
	private AddToCrlForm form;
	
	public AddToCrlAction(AddToCrlForm form) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Add to CRL");
		putValue(NAME, "Add to Crl");
		
		this.form=form;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		
		CertificateFactory certFactory = null;
		try {
			certFactory = CertificateFactory.getInstance("X.509");
		} catch (CertificateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(form.getSertifikati().get(form.getIzdavalac().getSelectedItem().toString()).getEncoded());
		} catch (CertificateEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		X509Certificate cert2 = null;
		try {
			cert2 = (X509Certificate)certFactory.generateCertificate(in);
		} catch (CertificateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ime=form.getIzdavalac().getSelectedItem().toString();
			 
		KeyStoreWriter ksw = new KeyStoreWriter();
	    //ovde smestamo sve
	    File f = new File("./data/sgns-revoked.jks");
	    if(!f.exists() || f.isDirectory()) { 
	    	ksw.loadKeyStore(null,"sgns-revoked".toCharArray());
	    }
	    else ksw.loadKeyStore("./data/sgns-revoked.jks","sgns-revoked".toCharArray());
	    
	    ksw.writeCertificate(ime, cert2);
		ksw.saveKeyStore("./data/sgns-revoked.jks", "sgns-revoked".toCharArray());
		
	    }
	
	


}
