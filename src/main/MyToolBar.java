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

import actions.Akcija1;
import actions.Akcija2;
import actions.Akcija3;
import actions.AddAction;



public class MyToolBar extends JToolBar{



	@SuppressWarnings("static-access")
	public MyToolBar(JDialog dialog) {
		super(SwingConstants.HORIZONTAL);

		JButton button;

		button = new JButton(new ImageIcon(getClass().getResource("/slike/search.gif")));
		button.setToolTipText("1");
		button.addActionListener(new Akcija1(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/refresh.gif")));
		button.setToolTipText("2");
		button.addActionListener(new Akcija2(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/zoom-pickup.gif")));
		button.setToolTipText("3");
		button.addActionListener(new Akcija3(dialog));
		this.add(button);
		
		addSeparator();

		button = new JButton(new ImageIcon(getClass().getResource("/slike/add.gif")));
		button.setToolTipText("3");
		button.addActionListener(new AddAction(dialog));
		this.add(button);
		
		
		this.setFloatable(false);

	}
	

}
