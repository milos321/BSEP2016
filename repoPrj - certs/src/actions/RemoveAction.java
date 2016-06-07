package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import main.MainFrame;

@SuppressWarnings("serial")
public class RemoveAction extends AbstractAction {
	
	private JDialog standardForm;
	
	public RemoveAction(JDialog standardForm) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Remove row");
		putValue(NAME, "Remove row");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		MainFrame.getInstance().remove();
		
	}

}
