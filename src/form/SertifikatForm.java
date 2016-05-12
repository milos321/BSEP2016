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
import actions.CancelAction;
import actions.CommitAction;


public class SertifikatForm extends JDialog{
	
	private JButton btnCommit;
	private JButton btnCancel;
	
	private JTextField days = new JTextField(20);
	private JTextField cn = new JTextField(20);
	private JTextField ou = new JTextField(20);
	private JTextField on = new JTextField(20);
	private JTextField l = new JTextField(20);
	private JTextField st = new JTextField(20);
	private JTextField c = new JTextField(20);
	private JTextField e = new JTextField(20);
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
		dataPanel.add(izdl);
		dataPanel.add(izdavalac);
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		buttonsPanel.add(btnCancel);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		
		
		
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

	public JTextField getDays() {
		return days;
	}

	public void setDays(JTextField days) {
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

	
	

}
