package main;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{
	
	
	public void open() throws SQLException {
		fireTableDataChanged();
	}

}
