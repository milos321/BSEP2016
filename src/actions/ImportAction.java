package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import main.MainFrame;
import security.KeyStoreReader;
import security.KeyStoreWriter;
import form.SertifikatForm;


@SuppressWarnings("serial")
public class ImportAction extends AbstractAction {
	
	private JDialog standardForm;

	
	public ImportAction(JDialog standardForm) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Import");
		putValue(NAME, "Import");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new CertificateFileFilter());
		
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
			//	ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(jfc.getSelectedFile()));
					CertificateFactory cf = CertificateFactory.getInstance("X.509");
				
						
//				SertifikatForm read=(SertifikatForm) os.readObject();	
//				String alias=read.getAlias().getText();
				Certificate cert =  cf.generateCertificate(bis);		
				String alias=jfc.getSelectedFile().getName();	
				MainFrame.getInstance().add(alias);
				
			    System.out.println(MainFrame.key_store_name);
			    System.out.println(MainFrame.key_store_pass);
			    System.out.println(alias);
				KeyStoreWriter ksw = new KeyStoreWriter();
				 File f = new File(MainFrame.key_store_name);
				    if(!f.exists() || f.isDirectory()) { 
				    	ksw.loadKeyStore(null,"sgns".toCharArray());
				    }
				    else ksw.loadKeyStore(MainFrame.key_store_name,MainFrame.key_store_pass);
				    
				    ksw.writeCertificate(alias, cert);
				    //kad ovo ne uspe, ceo keystore se izbrise
					ksw.saveKeyStore(MainFrame.key_store_name, MainFrame.key_store_pass);
	
				
		
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 



		}
		
	}

}
