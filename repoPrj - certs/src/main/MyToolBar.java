package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.NewKeystoreAction;
import actions.Akcija2;
import actions.RemoveAction;
import actions.AddAction;



public class MyToolBar extends JToolBar{



	public MyToolBar(JDialog dialog) {
		super(SwingConstants.HORIZONTAL);

		JButton button;

		button = new JButton(new ImageIcon(getClass().getResource("/slike/search.gif")));
		button.setToolTipText("1");
		button.addActionListener(new NewKeystoreAction(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/refresh.gif")));
		button.setToolTipText("2");
		button.addActionListener(new Akcija2(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/remove.gif")));
		button.setToolTipText("3");
		button.addActionListener(new RemoveAction(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/add.gif")));
		button.setToolTipText("4");
		button.addActionListener(new AddAction(dialog));
		this.add(button);
		
		
		this.setFloatable(false);

	}
	

}
