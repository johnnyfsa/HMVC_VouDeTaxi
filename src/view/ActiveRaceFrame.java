package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ActiveRaceFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActiveRaceFrame frame = new ActiveRaceFrame();
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
	public ActiveRaceFrame() {
		setTitle("Seu Motorista est\u00E1 \u00E0 caminho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 11, 354, 169);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		panel.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Placa");
		panel.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cor");
		panel.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Est\u00E1 \u00E0 caminho!");
		panel.add(lblNewLabel_4, "cell 1 5");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(46, 191, 354, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][]", "[]"));
		
		JButton cancelBtn = new JButton("Cancelar Corrida");
		panel_1.add(cancelBtn, "cell 0 0");
		
		JButton arriveBtn = new JButton("Meu motorista chegou");
		panel_1.add(arriveBtn, "cell 7 0");
	}

}
