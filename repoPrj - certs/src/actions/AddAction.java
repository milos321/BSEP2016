package actions;

import form.SertifikatForm;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.cert.CertificateException;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

public class AddAction extends AbstractAction{

private JDialog standardForm;
	
	public AddAction(JDialog standardForm) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Commit");
		putValue(NAME, "Commit");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		SertifikatForm form = null;
			try {
				form = new SertifikatForm();
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		form.setVisible(true);
		
	}
}
