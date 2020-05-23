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

public class ClienteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastro frame = new ClienteCadastro();
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
	public ClienteCadastro() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 201);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][grow][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 3,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 3 5 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 5,alignx trailing");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 5 5 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 7,alignx trailing");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 7 5 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 9,alignx trailing");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 9 3 1,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 11,alignx trailing");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 11 3 1,growx");
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 223, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		panel_1.add(confirmBtn, "cell 0 0");
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1, "cell 4 0");
		
		JButton cancelBtn = new JButton("Cancelar");
		panel_1.add(cancelBtn, "cell 8 0");
	}

}
