package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.FrameController;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPickFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPickFrame frame = new CadastroPickFrame();
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
	public CadastroPickFrame() {
		setTitle("Cadastrar Novo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][][][][]", "[][][][][][][]"));
		
		JButton clientBtn = new JButton("Cliente");
		clientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.resetFrames();
				FrameController.getClienteCadastro().setVisible(true);
				dispose();
			}
		});
		panel.add(clientBtn, "cell 6 2,growx");
		
		JButton taxiBtn = new JButton("Taxista");
		taxiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(FrameController.getCadastroPickFrame(),"Entre em contato com seu admnistrador");
			}
		});
		panel.add(taxiBtn, "cell 6 4,growx");
		
		JButton voltarBtn = new JButton("Voltar");
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.resetFrames();
				FrameController.getLoginView().setVisible(true);
				dispose();
			}
		});
		panel.add(voltarBtn, "cell 6 6,growx");
	}
}
