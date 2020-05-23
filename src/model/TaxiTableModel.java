package model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

public class TaxiTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames = {"Nome", "CPF"};
	private String[][] data;
	public String getColumnName(int col) 
	{
		return columnNames[col];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return data[arg0][arg1];
	}
	
	public void fillData( ArrayList<Taxi_Model> t) 
	{
		int line = t.size();
		data = new String[line][2];
		Iterator<Taxi_Model> taxiIterator = t.iterator();
		int i=0;
		int j=0;
		while(taxiIterator.hasNext()) 
		{
			Taxi_Model aux = taxiIterator.next();
			data[i][j] = aux.getNome();
			data[i][j+1] = aux.getCpf();
			if(i+1<line) 
			{
				i++;
			}
			
		}
	}
}
