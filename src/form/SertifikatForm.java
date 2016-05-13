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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import security.KeyStoreReader;
import actions.AddAction;
import actions.CancelAction;
import actions.CommitAction;


public class SertifikatForm extends JDialog{
	
	private JButton btnCommit;
	private JButton btnCancel;
	private HashMap<String,Certificate> sertifikati = new HashMap<String,Certificate>();
	
	String[] time={"30","180","365","730","1460"};
	


	private JComboBox<String> days = new JComboBox<String>(time);
	
	
	private JTextField cn = new JTextField(20);
	private JTextField ou = new JTextField(20);
	private JTextField on = new JTextField(20);
	private JTextField l = new JTextField(20);
	private JTextField st = new JTextField(20);
	private JTextField c = new JTextField(20);
	private JTextField e = new JTextField(20);
	private JComboBox<String> izdavalac = new JComboBox<String>();
	private JTextField alias = new JTextField(20);

	public SertifikatForm() throws CertificateException {
		
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
		btnCommit = new JButton(new CommitAction(this));
		btnCancel = new JButton(new CancelAction(this));

		
		JLabel daysl = new JLabel ("Validity(days):");
		JLabel cnl = new JLabel("Common Name (CN):");
		JLabel oul = new JLabel ("Organization unit (OU):");
		JLabel onl = new JLabel ("Organisation Name (ON):");
		JLabel ll = new JLabel("Locality Name (L):");
		JLabel stl = new JLabel("State Name (ST):");
		JLabel cl = new JLabel("Country (C):");
		JLabel el = new JLabel("Email (E):");
		JLabel izdl = new JLabel("Issuer:");
		JLabel ali  = new JLabel("Alias");

		dataPanel.add(daysl);
		dataPanel.add(days,"wrap");
		dataPanel.add(cnl);
		dataPanel.add(cn,"wrap");
		dataPanel.add(oul);
		dataPanel.add(ou,"wrap");
		dataPanel.add(onl);
		dataPanel.add(on,"wrap");
		dataPanel.add(ll);
		dataPanel.add(l,"wrap");
		dataPanel.add(stl);
		dataPanel.add(st,"wrap");
		dataPanel.add(cl);
		dataPanel.add(c, "wrap");
		dataPanel.add(el);
		dataPanel.add(e, "wrap");
		dataPanel.add(ali);
		dataPanel.add(alias,"wrap");
		dataPanel.add(izdl);
		
		dataPanel.add(izdavalac);
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		buttonsPanel.add(btnCancel);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		izdavalac.addItem("samopotpisan");
		
		KeyStoreReader ksr = new KeyStoreReader();
		
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
		izdavalac.addItem(it2.next().toString());
		
		}
	    }
		
	}

	public JButton getBtnCommit() {
		return btnCommit;
	}

	public void setBtnCommit(JButton btnCommit) {
		this.btnCommit = btnCommit;
	}
	
	

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	
	
	

	public JComboBox getDays() {
		return days;
	}

	public void setDays(JComboBox days) {
		this.days = days;
	}

	public JTextField getCn() {
		return cn;
	}

	public void setCn(JTextField cn) {
		this.cn = cn;
	}

	public JTextField getOu() {
		return ou;
	}

	public void setOu(JTextField ou) {
		this.ou = ou;
	}

	public JTextField getOn() {
		return on;
	}

	public void setOn(JTextField on) {
		this.on = on;
	}

	public JTextField getL() {
		return l;
	}

	public void setL(JTextField l) {
		this.l = l;
	}

	public JTextField getSt() {
		return st;
	}

	public void setSt(JTextField st) {
		this.st = st;
	}

	public JTextField getC() {
		return c;
	}

	public void setC(JTextField c) {
		this.c = c;
	}

	public JTextField getE() {
		return e;
	}

	public void setE(JTextField e) {
		this.e = e;
	}

	public JComboBox getIzdavalac() {
		return izdavalac;
	}

	public void setIzdavalac(JComboBox izdavalac) {
		this.izdavalac = izdavalac;
	}

	public JTextField getAlias() {
		return alias;
	}

	public void setAlias(JTextField alias) {
		this.alias = alias;
	}

	public HashMap<String,Certificate> getSertifikati() {
		return sertifikati;
	}

	public void setSertifikati(HashMap<String,Certificate> sertifikati) {
		this.sertifikati = sertifikati;
	}

	
	

}
