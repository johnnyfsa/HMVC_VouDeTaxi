package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

public class TaxiSearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(15, 69, 583, 20);
		contentPane_1.add(textField);
		
		JLabel searchLbl = new JLabel("Procurar por:");
		searchLbl.setBounds(10, 40, 101, 23);
		contentPane_1.add(searchLbl);
		
		JRadioButton rdbtName = new JRadioButton("Nome");
		rdbtName.setSelected(true);
		rdbtName.setBounds(213, 40, 109, 23);
		contentPane_1.add(rdbtName);
		
		JRadioButton rdbtRg = new JRadioButton("RG");
		rdbtRg.setBounds(324, 40, 109, 23);
		contentPane_1.add(rdbtRg);
		
		JRadioButton rdbtCpf = new JRadioButton("CPF");
		rdbtCpf.setBounds(435, 40, 109, 23);
		contentPane_1.add(rdbtCpf);
		
		JButton confirmBtn = new JButton("ok");
		confirmBtn.setBounds(509, 100, 89, 23);
		contentPane_1.add(confirmBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 383, 573, 116);
		contentPane_1.add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][]", "[][][][]"));
		
		JButton btnNewButton = new JButton("Cadastrar");
		panel.add(btnNewButton, "cell 0 0");
		
		JButton btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1, "cell 7 0,growx");
		
		JButton btnNewButton_2 = new JButton("Remover");
		panel.add(btnNewButton_2, "cell 14 0");
		
		JButton btnNewButton_3 = new JButton("Voltar");
		panel.add(btnNewButton_3, "cell 14 3,growx");
	}

}
