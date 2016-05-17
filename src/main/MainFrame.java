package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import actions.ImportAction;
import actions.NewKeystoreAction;
import actions.Akcija2;
import actions.RemoveAction;
import actions.OpenExportFormAction;
import actions.OpenKeystoreAction;
import security.KeyStoreReader;


public class MainFrame extends JFrame {

	private static MainFrame frame = null;
	private JMenuBar menuBar;
	private MyToolBar toolbar;
	public  JTable table;
	DefaultTableModel model;
	public static String key_store_name="./data/sgns.jks";
	public static char[] key_store_pass="sgns".toCharArray();

	public MainFrame() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Bezbednost");
		int width = (int) (screen.getWidth() * 0.5);
		int height = (int) (screen.getHeight() * 0.5);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		Menu();
		this.setJMenuBar(menuBar);
		toolbar = new MyToolBar(null);
		add(toolbar,BorderLayout.NORTH);
		initTable();

	}

	public static MainFrame getInstance() {
		if(frame == null) {
			frame = new MainFrame();
		}
		return frame;
	}

	private void Menu(){
		menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		JMenu ex = new JMenu("Examine");
		JMenu help = new JMenu("Help");

		JMenuItem ks = new JMenuItem(new NewKeystoreAction(null));
		file.add(ks);
		JMenuItem imp = new JMenuItem(new ImportAction(null));
		file.add(imp);
		JMenuItem exp = new JMenuItem(new OpenExportFormAction());
		file.add(exp);
		JMenuItem openKS = new JMenuItem(new OpenKeystoreAction());
		file.add(openKS);
		JMenuItem t = new JMenuItem(new Akcija2(null));
		tools.add(t);
		JMenuItem e = new JMenuItem(new RemoveAction(null));
		ex.add(e);


		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(ex);
		menuBar.add(help);


	}

	public JTable initTable(){


		Vector rowData = new Vector();

		model = new DefaultTableModel(); 

		table = new JTable(model);

		model.addColumn("Alias name"); 
		model.addColumn("Last Modified"); 


		//	model.addRow(new Object[]{"aasdsads", date});

		//Dozvoljeno selektovanje redova
		table.setRowSelectionAllowed(true);
		//Ali ne i selektovanje kolona 
		table.setColumnSelectionAllowed(false);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//	table.setRowSelectionInterval(0, 0);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		HashMap<String,Certificate> sertifikati = new HashMap<String,Certificate>();
		File f = new File(key_store_name);
		KeyStoreReader ksr = new KeyStoreReader();
		if(f.exists() && !f.isDirectory()) {

			ksr.setKeyStoreFile(f.getPath());
			ksr.setPassword(key_store_pass);


			sertifikati=ksr.readKeyStore();

		}
	//	setAliases(sertifikati.keySet());


		return table;

	}

	public void add(String alias){


		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		Date date = today.getTime();

		String str=alias.toString();
		int duzina=str.length();
		int konacno=duzina - 4; //bez .cer

		model.addRow(new Object[]{str.substring(0, konacno), date});
	//	model.addRow(new Object[]{alias, date});

		model.fireTableDataChanged();

	}

	public void remove(){

		int index=table.getSelectedRow();

		if (index == -1) //Ako nema selektovanog reda (tabela prazna)
			return; // izlazak
		//kada obrisemo tekuci red, selektovacemo sledeci (newindex):
		int newIndex = index;
		//sem ako se obrise poslednji red, tada selektujemo prethodni
		if (index == model.getRowCount() - 1)
			newIndex--;

		model.removeRow(index);
		if (model.getRowCount() > 0)
			table.setRowSelectionInterval(newIndex, newIndex);
	}

	public void setAliases(Set<String> keySet) {
		// TODO Auto-generated method stub

		Iterator it = keySet.iterator();

		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		Date date = today.getTime();

		model.setRowCount(0);
		while(it.hasNext()){
			String str=it.next().toString();
			String provera;
			if(str.length()>4){
				provera=str.substring(str.length()-4, str.length());
				System.out.print(provera);
				if(provera.contains(".cer")){
					int duzina=str.length();
					int konacno=duzina - 4; //bez .cer
					//ispisuje string bez .cer ekstenzije
					model.addRow(new Object[]{str.substring(0, konacno), date}); 
				}else{
					model.addRow(new Object[]{str, date});
				}
			}else{
				model.addRow(new Object[]{str, date});
			}

		}


		model.fireTableDataChanged();

	}
}
