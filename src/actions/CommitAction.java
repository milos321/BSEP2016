package actions;

import form.SertifikatForm;
import security.SubjectData;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

public class CommitAction extends AbstractAction{

private JDialog standardForm;
	
	public CommitAction(JDialog standardForm) {
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);
		putValue(ACCELERATOR_KEY,ctrlDKeyStroke);
		putValue(SHORT_DESCRIPTION, "Commit");
		putValue(NAME, "Commit");
		
		this.standardForm=standardForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		if(standardForm instanceof SertifikatForm)
		{
			SertifikatForm sertForm = (SertifikatForm)standardForm;
			//C
			String c = sertForm.getC().getText();
			//L
			String l = sertForm.getL().getText();
			//O
			String on = sertForm.getOn().getText();
			//OU		
			String ou = sertForm.getOu().getText();
			//CN	
			String cn = sertForm.getCn().getText();
			//Days
			String ime = sertForm.getDays().getText();
			//Email
			String prz = sertForm.getE().getText();
			X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
		    builder.addRDN(BCStyle.CN, cn);
		    builder.addRDN(BCStyle.SURNAME, "Sladic");
		    builder.addRDN(BCStyle.GIVENNAME, "Goran");
		    builder.addRDN(BCStyle.O, "UNS-FTN");
		    builder.addRDN(BCStyle.OU, "Katedra za informatiku");
		    builder.addRDN(BCStyle.C, "RS");
		    //builder.addRDN(BCStyle.E, "sladicg@uns.ac.rs");
		    //UID (USER ID) je ID korisnika
		    builder.addRDN(BCStyle.UID, "123445");
			
		    //Serijski broj sertifikata
			String sn="1";
		}
		standardForm.dispose();
	}
}
