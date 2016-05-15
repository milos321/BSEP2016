package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import actions.ImportAction;
import actions.NewKeystoreAction;
import actions.Akcija2;
import actions.Akcija3;
import actions.OpenExportFormAction;


public class MainFrame extends JFrame {

	private static MainFrame frame = null;
	private JMenuBar menuBar;
	private MyToolBar toolbar;
	
	private MainFrame() {
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
		JMenuItem t = new JMenuItem(new Akcija2(null));
		tools.add(t);
		JMenuItem e = new JMenuItem(new Akcija3(null));
		ex.add(e);
		

		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(ex);
		menuBar.add(help);
		
		
	}
}
