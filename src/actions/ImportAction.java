package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import main.MainFrame;
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
				String alias=cert.toString();
				
				System.out.print(alias);
	
				
		
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
