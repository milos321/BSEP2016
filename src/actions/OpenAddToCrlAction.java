package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.cert.CertificateException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import form.AddToCrlForm;
import form.ExportForm;

public class OpenAddToCrlAction extends AbstractAction {
	
	private JDialog standardForm;
	
	public OpenAddToCrlAction() {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Add to crl");
		putValue(NAME, "Add to crl");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		AddToCrlForm form = null;
		try {
			form = new AddToCrlForm();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	form.setVisible(true);
	}

}