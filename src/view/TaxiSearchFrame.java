package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.FrameController;
import control.Taxi_Controller;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class TaxiSearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiSearchFrame frame = new TaxiSearchFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaxiSearchFrame() {
		setTitle("Buscar Taxista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 144, 583, 214);
		contentPane_1.add(scrollPane);
		
		Taxi_Controller.fillTableModel(Taxi_Controller.getList());
		//table = new JTable(Taxi_Controller.getTaxiTableModel());
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(15, 69, 583, 20);
		contentPane_1.add(textField);
		
		JLabel searchLbl = new JLabel("Procurar por:");
		searchLbl.setBounds(10, 40, 101, 23);
		contentPane_1.add(searchLbl);
		
		JRadioButton rdbtName = new JRadioButton("Nome");
		buttonGroup.add(rdbtName);
		rdbtName.setSelected(true);
		rdbtName.setBounds(213, 40, 109, 23);
		contentPane_1.add(rdbtName);
		
		JRadioButton rdbtUser = new JRadioButton("Usuario");
		buttonGroup.add(rdbtUser);
		rdbtUser.setBounds(324, 40, 109, 23);
		contentPane_1.add(rdbtUser);
		
		JRadioButton rdbtCpf = new JRadioButton("CPF");
		buttonGroup.add(rdbtCpf);
		rdbtCpf.setBounds(435, 40, 109, 23);
		contentPane_1.add(rdbtCpf);
		
		JButton confirmBtn = new JButton("ok");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = textField.getText();
				if(key.isEmpty()) 
				{
					Taxi_Controller.fillTableModel(Taxi_Controller.getList());
					table.repaint();
				}
				else 
				{
					if(rdbtName.isSelected()) 
					{
						Taxi_Controller.fillTableModel(Taxi_Controller.busca(key, "", ""));
						table.repaint();
					}
					else if(rdbtUser.isSelected()) 
					{
						Taxi_Controller.fillTableModel(Taxi_Controller.busca("", key, ""));
						table.repaint();
					}
					else if(rdbtCpf.isSelected()) 
					{
						Taxi_Controller.fillTableModel(Taxi_Controller.busca("", "", key));
						table.repaint();
					}
				}
				
				
			}
		});
		confirmBtn.setBounds(509, 100, 89, 23);
		contentPane_1.add(confirmBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 383, 573, 116);
		contentPane_1.add(panel);
		panel.setLayout(new MigLayout("", "[][111.00][][][][][][][][][][][][82.00][]", "[][][][]"));
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow(); // select a row
					int column = table.getSelectedColumn(); // select a column
					FrameController.setEditarTaxi(new EditarTaxi((String)table.getValueAt(row, 1)));//cpf
					FrameController.getEditarTaxi().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Selecione Alguma Linha da Tabela");
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1, "cell 0 0 2 1,growx");
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); // select a row
				Taxi_Controller.remover("", "", (String) table.getValueAt(row, 1));
				Taxi_Controller.fillTableModel(Taxi_Controller.getList());
				table.repaint();
			}
		});
		panel.add(btnNewButton_2, "cell 14 0");
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getAdmLandPage().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_3, "cell 14 3,growx");
	}
}
