package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import form.ExportForm;
import form.SertifikatForm;


public class ExportAction extends AbstractAction {
	
	private ExportForm form;
	
	public ExportAction(ExportForm form) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Export");
		putValue(NAME, "Export");
		
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
			 
	        try {
	
	            final FileOutputStream os = new FileOutputStream("./data/" + ime
	                    + ".cer");
	            os.write(cert2.getEncoded());
	            os.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (CertificateEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       
	        form.dispose();
	    }
	
	


}
