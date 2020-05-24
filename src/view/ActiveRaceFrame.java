package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Corrida_Controller;
import control.FrameController;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActiveRaceFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTxt;
	private JTextField modeloTxt;
	private JTextField placaTxt;
	private JTextField corTxt;

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
		
		String Nome, Modelo, Placa, Cor;
		Nome = Corrida_Controller.getCorrida().getTaxi().getNome();
		Modelo = Corrida_Controller.getCorrida().getTaxi().getModeloCarro();
		Placa = Corrida_Controller.getCorrida().getTaxi().getPlaca();
		Cor = Corrida_Controller.getCorrida().getTaxi().getCorCarro();
		
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
		
		nomeTxt = new JTextField();
		nomeTxt.setEditable(false);
		panel.add(nomeTxt, "cell 1 1,growx");
		nomeTxt.setColumns(10);
		nomeTxt.setText(Nome);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		panel.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		modeloTxt = new JTextField();
		modeloTxt.setEditable(false);
		panel.add(modeloTxt, "cell 1 2,growx");
		modeloTxt.setColumns(10);
		modeloTxt.setText(Modelo);
		
		JLabel lblNewLabel_2 = new JLabel("Placa");
		panel.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		placaTxt = new JTextField();
		placaTxt.setEditable(false);
		panel.add(placaTxt, "cell 1 3,growx");
		placaTxt.setColumns(10);
		placaTxt.setText(Placa);
		
		JLabel lblNewLabel_3 = new JLabel("Cor");
		panel.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		corTxt = new JTextField();
		corTxt.setEditable(false);
		panel.add(corTxt, "cell 1 4,growx");
		corTxt.setColumns(10);
		corTxt.setText(Cor);
		
		JLabel lblNewLabel_4 = new JLabel("Est\u00E1 \u00E0 caminho!");
		panel.add(lblNewLabel_4, "cell 1 5");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(46, 191, 354, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][]", "[]"));
		
		JButton cancelBtn = new JButton("Cancelar Corrida");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Corrida_Controller.reset();
				FrameController.getClienteLandPage().setVisible(true);
				dispose();
			}
		});
		panel_1.add(cancelBtn, "cell 0 0");
		
		JButton arriveBtn = new JButton("Meu motorista chegou");
		arriveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getScoreFrame().setVisible(true);
				dispose();
			}
		});
		panel_1.add(arriveBtn, "cell 7 0");
	}

}
