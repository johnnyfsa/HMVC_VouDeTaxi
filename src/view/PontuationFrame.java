package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PontuationFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PontuationFrame frame = new PontuationFrame();
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
	public PontuationFrame() {
		setTitle("Avalie seu Motorista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 158);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[60.00][52.00][47.00][49.00][49.00][]", "[][][]"));
		
		JRadioButton chckbx1 = new JRadioButton("1");
		buttonGroup.add(chckbx1);
		panel.add(chckbx1, "cell 0 1");
		
		JRadioButton chckbx2 = new JRadioButton("2");
		buttonGroup.add(chckbx2);
		panel.add(chckbx2, "cell 1 1");
		
		JRadioButton chckbx3 = new JRadioButton("3");
		buttonGroup.add(chckbx3);
		panel.add(chckbx3, "cell 2 1");
		
		JRadioButton chckbx4 = new JRadioButton("4");
		buttonGroup.add(chckbx4);
		panel.add(chckbx4, "cell 3 1");
		
		JRadioButton chckbx5 = new JRadioButton("5");
		buttonGroup.add(chckbx5);
		panel.add(chckbx5, "cell 4 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 184, 307, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][]", "[]"));
		
		JButton endBtn = new JButton("Finalizar Corrida");
		panel_1.add(endBtn, "cell 3 0");
	}
}
