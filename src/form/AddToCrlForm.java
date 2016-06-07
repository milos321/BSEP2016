package form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.AddToCrlAction;
import actions.ExportAction;
import net.miginfocom.swing.MigLayout;
import security.KeyStoreReader;

public class AddToCrlForm extends JDialog{

	private JButton btnCommit;
	private HashMap<String,Certificate> sertifikati = new HashMap<String,Certificate>();
	private JComboBox<String> izdavalac = new JComboBox<String>();


	public AddToCrlForm() throws CertificateException {

		setLayout(new MigLayout("fill"));

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screen.getWidth() * 0.5);
		int height = (int) (screen.getHeight() * 0.5);
		this.setSize(width, height);
		//	setSize(new Dimension(800, 600));
		setTitle("Sertifikat");
		setLocationRelativeTo(null);
		setModal(true);

		initGui();
		// TODO Auto-generated constructor stub
	}

	private void initGui() throws CertificateException{

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("fillx"));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new MigLayout("gapx 15px"));


		JPanel buttonsPanel = new JPanel();
		btnCommit = new JButton(new AddToCrlAction(this));





		JLabel izdl = new JLabel("Sertifikat:");


		dataPanel.add(izdl);

		dataPanel.add(izdavalac);
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		KeyStoreReader ksr = new KeyStoreReader();
		
		//za popunjavanje combo-boxa
		File f = new File("./data/sgns.jks");
		if(f.exists() && !f.isDirectory()) {
			ksr.setKeyStoreFile("./data/sgns.jks");

			sertifikati=ksr.readKeyStore();

			Iterator it = sertifikati.values().iterator();
			Iterator it2 = sertifikati.keySet().iterator();
			while(it.hasNext())
			{
				CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
				InputStream in = new ByteArrayInputStream(((Certificate) it.next()).getEncoded());
				X509Certificate cert2 = (X509Certificate)certFactory.generateCertificate(in);
				String naziv = it2.next().toString();
				if(!naziv.equals("sgns"))
				izdavalac.addItem(naziv);

			}
		}

	}

	public JButton getBtnCommit() {
		return btnCommit;
	}

	public void setBtnCommit(JButton btnCommit) {
		this.btnCommit = btnCommit;
	}







	public JComboBox getIzdavalac() {
		return izdavalac;
	}

	public void setIzdavalac(JComboBox izdavalac) {
		this.izdavalac = izdavalac;
	}



	public HashMap<String,Certificate> getSertifikati() {
		return sertifikati;
	}

	public void setSertifikati(HashMap<String,Certificate> sertifikati) {
		this.sertifikati = sertifikati;
	}




}
