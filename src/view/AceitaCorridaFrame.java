package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Corrida_Controller;
import control.FrameController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AceitaCorridaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField partidax;
	private JTextField partiday;
	private JTextField chegadax;
	private JTextField chegaday;
	private JTextField nomeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceitaCorridaFrame frame = new AceitaCorridaFrame();
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
	public AceitaCorridaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 12, 387, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		partidax = new JTextField();
		partidax.setBounds(26, 44, 114, 19);
		panel.add(partidax);
		partidax.setColumns(10);
		
		partiday = new JTextField();
		partiday.setColumns(10);
		partiday.setBounds(26, 87, 114, 19);
		panel.add(partiday);
		
		chegadax = new JTextField();
		chegadax.setColumns(10);
		chegadax.setBounds(232, 44, 114, 19);
		panel.add(chegadax);
		
		chegaday = new JTextField();
		chegaday.setColumns(10);
		chegaday.setBounds(232, 87, 114, 19);
		panel.add(chegaday);
		
		JLabel lblPartida = new JLabel("Partida");
		lblPartida.setBounds(43, 12, 70, 15);
		panel.add(lblPartida);
		
		JLabel lblChegada = new JLabel("Chegada");
		lblChegada.setBounds(248, 12, 70, 15);
		panel.add(lblChegada);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 118, 70, 15);
		panel.add(lblNome);
		
		nomeCliente = new JTextField();
		nomeCliente.setBounds(63, 116, 293, 19);
		panel.add(nomeCliente);
		nomeCliente.setColumns(10);
		
		
		
		JButton naoAceita = new JButton("N\u00E3o Aceitar");
		naoAceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Corrida_Controller.aceitaCorrida(false);
				FrameController.resetFrames();
				FrameController.getTaxiLandPage().setVisible(true);
				dispose();
				
			}
		});
		naoAceita.setBounds(242, 201, 117, 25);
		contentPane.add(naoAceita);
		
		JButton aceitar = new JButton("Aceitar");
		aceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Corrida_Controller.aceitaCorrida(true);
				aceitar.setEnabled(false);
				naoAceita.setEnabled(false);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Corrida_Controller.reset();
				
				if(Corrida_Controller.getCorrida().getCliente().getNome().isEmpty()) 
				{
					JOptionPane.showMessageDialog(FrameController.getAceitaCorridaFrame(),"Sua corrida Foi finalizada");
					FrameController.resetFrames();
					FrameController.getTaxiLandPage().setVisible(true);
					dispose();
				}
				
			}
		});
		aceitar.setBounds(54, 201, 117, 25);
		contentPane.add(aceitar);
		
		//setando as tFields com dados do cliente
		nomeCliente.setText(Corrida_Controller.getCorrida().getCliente().getNome()); 
		partidax.setText(""+Corrida_Controller.getCorrida().getPartida()[0]);
		partiday.setText(""+Corrida_Controller.getCorrida().getPartida()[1]);
		chegadax.setText(""+Corrida_Controller.getCorrida().getChegada()[0]);
		chegaday.setText(""+Corrida_Controller.getCorrida().getChegada()[1]);
	}
}
