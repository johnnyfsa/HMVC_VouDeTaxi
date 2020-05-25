package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TaxiCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiCadastro frame = new TaxiCadastro();
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
	public TaxiCadastro() {
		setTitle("Cadastro de Taxista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 294);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[80px][229px]", "[20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,growx,aligny top");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 1,growx,aligny top");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 2,growx,aligny top");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 3,alignx right,aligny center");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 3,growx,aligny top");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 4,alignx left,aligny center");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 4,growx,aligny top");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de carro");
		panel.add(lblNewLabel_5, "cell 0 5,alignx right,aligny center");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "cell 1 5,growx,aligny top");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cor");
		panel.add(lblNewLabel_6, "cell 0 6,alignx right,aligny center");
		
		textField_6 = new JTextField();
		panel.add(textField_6, "cell 1 6,alignx left,aligny top");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Placa");
		panel.add(lblNewLabel_7, "cell 0 7,alignx right,aligny center");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 1 7,alignx left,aligny top");
		textField_7.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 316, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[79px][75px][][][][][][][][]", "[23px]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		panel_1.add(confirmBtn, "cell 0 0,alignx left,aligny top");
		
		JButton cancelBtn = new JButton("Cancelar");
		panel_1.add(cancelBtn, "cell 9 0,alignx left,aligny top");
	}

}
