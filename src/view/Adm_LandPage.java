package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adm_LandPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adm_LandPage frame = new Adm_LandPage();
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
	public Adm_LandPage() {
		setTitle("Painel Geral Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 188, 257);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][]", "[][][][]"));
		
		JButton cadastraTaxiBtn = new JButton("Cadastrar Taxista");
		panel.add(cadastraTaxiBtn, "cell 0 1,growx,aligny center");
		
		JButton buscaTaxiBtn = new JButton("Buscar Taxista");
		panel.add(buscaTaxiBtn, "cell 0 2,growx");
		
		JButton relatorioGeralBtn = new JButton("Exibir Relatorio Geral");
		panel.add(relatorioGeralBtn, "cell 0 3,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(346, 11, 188, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][]", "[]"));
		
		JButton admAcountBtn = new JButton("Minha Conta");
		panel_1.add(admAcountBtn, "cell 3 0");
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(346, 257, 188, 93);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
		
		JButton logoffBtn = new JButton("Logoff");
		logoffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1_1.add(logoffBtn, "cell 5 2");
	}
}
