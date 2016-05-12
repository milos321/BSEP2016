package form;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import actions.AddAction;
import actions.CommitAction;


public class SertifikatForm extends JDialog{
	
	private JButton btnCommit;
	private JTextField ime = new JTextField(15);
	private JTextField prz = new JTextField(20);
	

	private JTextField jmbg = new JTextField(13);
	private JTextField mesto = new JTextField(20);
	private JTextField adresa = new JTextField(20);
	private JTextField broj = new JTextField(5);
	private JTextField cn = new JTextField(20);
	private JComboBox izdavalac = new JComboBox();

	public SertifikatForm() {
		
		setLayout(new MigLayout("fill"));
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screen.getWidth() * 0.25);
		int height = (int) (screen.getHeight() * 0.25);
		this.setSize(width, height);
	//	setSize(new Dimension(800, 600));
		setTitle("Sertifikat");
		setLocationRelativeTo(null);
		setModal(true);
		
		initGui();
		// TODO Auto-generated constructor stub
	}
	
	private void initGui(){

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("fillx"));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new MigLayout("gapx 15px"));
	

		JPanel buttonsPanel = new JPanel();
		btnCommit = new JButton(new CommitAction(this));


		
		JLabel im = new JLabel ("Ime:");
		JLabel pr = new JLabel("Prezime:");
		JLabel jm = new JLabel ("JMBG:");
		JLabel me = new JLabel("Mesto:");
		JLabel ad = new JLabel ("Adresa:");
		JLabel br = new JLabel("Broj:");
		JLabel cnLab = new JLabel("CN: ");
		JLabel izd = new JLabel("Izdavalac:");

		dataPanel.add(im);
		dataPanel.add(ime,"wrap");
		dataPanel.add(pr);
		dataPanel.add(prz,"wrap");
		dataPanel.add(jm);
		dataPanel.add(jmbg,"wrap");
		dataPanel.add(me);
		dataPanel.add(mesto,"wrap");
		dataPanel.add(ad);
		dataPanel.add(adresa,"wrap");
		dataPanel.add(br);
		dataPanel.add(broj,"wrap");
		dataPanel.add(cnLab);
		dataPanel.add(cn, "wrap");
		dataPanel.add(izd);
		dataPanel.add(izdavalac);
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		
		
		
	}
	
	public JButton getBtnCommit() {
		return btnCommit;
	}

	public void setBtnCommit(JButton btnCommit) {
		this.btnCommit = btnCommit;
	}

	public JTextField getIme() {
		return ime;
	}

	public void setIme(JTextField ime) {
		this.ime = ime;
	}

	public JTextField getPrz() {
		return prz;
	}

	public void setPrz(JTextField prz) {
		this.prz = prz;
	}

	public JTextField getJmbg() {
		return jmbg;
	}

	public void setJmbg(JTextField jmbg) {
		this.jmbg = jmbg;
	}

	public JTextField getMesto() {
		return mesto;
	}

	public void setMesto(JTextField mesto) {
		this.mesto = mesto;
	}

	public JTextField getAdresa() {
		return adresa;
	}

	public void setAdresa(JTextField adresa) {
		this.adresa = adresa;
	}

	public JTextField getBroj() {
		return broj;
	}

	public void setBroj(JTextField broj) {
		this.broj = broj;
	}

	public JComboBox getIzdavalac() {
		return izdavalac;
	}

	public void setIzdavalac(JComboBox izdavalac) {
		this.izdavalac = izdavalac;
	}

	public JTextField getCn() {
		return cn;
	}

	public void setCn(JTextField cn) {
		this.cn = cn;
	}

}
