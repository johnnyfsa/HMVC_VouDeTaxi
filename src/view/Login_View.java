package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class Login_View extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField pswdTextField;
	private JButton confirmBtn;
	private JButton cadastraBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_View frame = new Login_View();
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
	public Login_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 21, 274, 151);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow][][][grow]", "[][][][]"));
		
		lblNewLabel = new JLabel("Usuario");
		panel.add(lblNewLabel, "cell 0 0");
		
		userTextField = new JTextField();
		panel.add(userTextField, "cell 0 1 4 1,growx");
		userTextField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Senha");
		panel.add(lblNewLabel_1, "cell 0 2");
		
		pswdTextField = new JTextField();
		panel.add(pswdTextField, "cell 0 3 4 1,growx");
		pswdTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(83, 197, 274, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][]", "[]"));
		
		confirmBtn = new JButton("Confirmar");
		panel_1.add(confirmBtn, "cell 0 0");
		
		cadastraBtn = new JButton("Cadastrar Conta");
		panel_1.add(cadastraBtn, "cell 6 0");
	}
}
