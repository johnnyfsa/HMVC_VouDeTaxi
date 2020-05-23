package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteLandPage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteLandPage frame = new ClienteLandPage();
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
	public ClienteLandPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(351, 11, 106, 41);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton clienteEditBtn = new JButton("Minha Conta");
		panel.add(clienteEditBtn, "cell 1 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 228, 447, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[][]"));
		
		JButton generateRaceBtn = new JButton("Gerar Corrida");
		panel_1.add(generateRaceBtn, "cell 6 1,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 109, 447, 98);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][75.00][52.00][70.00][][][][][grow][][grow]", "[][][]"));
		
		JRadioButton rdbtnNow = new JRadioButton("Pra Agora");
		rdbtnNow.setSelected(true);
		panel_2.add(rdbtnNow, "cell 0 0");
		buttonGroup.add(rdbtnNow);
		
		JRadioButton rdbtnLater = new JRadioButton("Para Depois");
		panel_2.add(rdbtnLater, "cell 0 1");
		buttonGroup.add(rdbtnLater);
		
		JLabel lblNewLabel_2 = new JLabel("Quando?");
		panel_2.add(lblNewLabel_2, "cell 0 2");
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		panel_2.add(lblNewLabel_3, "cell 1 2");
		
		JFormattedTextField dateFtf = new JFormattedTextField();
		dateFtf.setEditable(false);
		panel_2.add(dateFtf, "cell 2 2,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Hora");
		panel_2.add(lblNewLabel_4, "cell 3 2,alignx trailing");
		
		JFormattedTextField hourFtf = new JFormattedTextField();
		hourFtf.setEditable(false);
		panel_2.add(hourFtf, "cell 4 2,growx");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 312, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("Latitude");
		panel_3.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		panel_3.add(textField, "cell 1 0,alignx left");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Longitude");
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "cell 1 1,alignx left");
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(351, 333, 106, 41);
		contentPane.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton btnNewButton_1 = new JButton("Logoff");
		panel_4.add(btnNewButton_1, "cell 1 0");
		
		rdbtnNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateFtf.setEditable(false);
				hourFtf.setEditable(false);
			}
		});
		
		rdbtnLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateFtf.setEditable(true);
				hourFtf.setEditable(true);
			}
		});
	}
}
