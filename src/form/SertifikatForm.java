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
		dataPanel.add(izd);
		dataPanel.add(izdavalac);
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		
		
		
	}

}
