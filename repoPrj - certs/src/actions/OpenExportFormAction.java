package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.cert.CertificateException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import form.ExportForm;
import form.SertifikatForm;

public class OpenExportFormAction extends AbstractAction {
	
	private JDialog standardForm;
	
	public OpenExportFormAction() {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Export");
		putValue(NAME, "Export");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		ExportForm form = null;
		try {
			form = new ExportForm();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	form.setVisible(true);
	}

}