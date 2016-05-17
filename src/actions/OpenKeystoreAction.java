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
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;

import form.ExportForm;
import main.MainFrame;
import security.KeyStoreReader;
import security.KeyStoreWriter;

public class OpenKeystoreAction extends AbstractAction {
	
	private JDialog standardForm;
	
	public OpenKeystoreAction() {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Open keystore");
		putValue(NAME, "Open keystore");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		JFileChooser jfc = new JFileChooser();
		HashMap<String,Certificate> sertifikati = new HashMap<String,Certificate>();
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			
			char[] password=null;
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Enter a password:");
			JPasswordField pass = new JPasswordField(10);
			panel.add(label);
			panel.add(pass);
			String[] options = new String[]{"OK", "Cancel"};
			int option = JOptionPane.showOptionDialog(null, panel, "The title",
			                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
			                         null, options, options[1]);
			if(option == 0) // pressing OK button
			{
			    password = pass.getPassword();
			    System.out.println("Your password is: " + new String(password));
			}
			
			
			File f = jfc.getSelectedFile();
			KeyStoreReader ksr = new KeyStoreReader();
			if(f.exists() && !f.isDirectory()) {
			
				MainFrame.key_store_name=jfc.getSelectedFile().getPath();
				MainFrame.key_store_pass=password;
				ksr.setKeyStoreFile(f.getPath());
				ksr.setPassword(password);
				

				sertifikati=ksr.readKeyStore();
				
			}
			MainFrame.getInstance().setAliases(sertifikati.keySet());
			
		}
	}
		

}