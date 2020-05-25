package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VisualizarTaxi extends JFrame {

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
					VisualizarTaxi frame = new VisualizarTaxi();
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
	public VisualizarTaxi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 414, 294);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(60, 30, 27, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 27, 229, 20);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(68, 60, 19, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 57, 229, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(51, 91, 36, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 88, 229, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(57, 121, 30, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 118, 171, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		lblNewLabel_4.setBounds(7, 152, 80, 14);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 149, 171, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de carro");
		lblNewLabel_5.setBounds(10, 183, 77, 14);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 180, 229, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cor");
		lblNewLabel_6.setBounds(70, 213, 17, 14);
		panel.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(91, 210, 113, 20);
		panel.add(textField_6);
		
		JLabel lblNewLabel_7 = new JLabel("Placa");
		lblNewLabel_7.setBounds(62, 244, 25, 14);
		panel.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(91, 241, 113, 20);
		panel.add(textField_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 316, 414, 51);
		contentPane.add(panel_1);
		
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.setBounds(7, 7, 79, 23);
		panel_1.add(confirmBtn);
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(332, 7, 75, 23);
		panel_1.add(cancelBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(161, 7, 89, 23);
		panel_1.add(deleteBtn);
	}

}
