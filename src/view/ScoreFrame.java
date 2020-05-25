package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Corrida_Controller;
import control.FrameController;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreFrame frame = new ScoreFrame();
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
	public ScoreFrame() {
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
		
		JRadioButton nota1 = new JRadioButton("1");
		buttonGroup.add(nota1);
		panel.add(nota1, "cell 0 1");
		
		JRadioButton nota2 = new JRadioButton("2");
		buttonGroup.add(nota2);
		panel.add(nota2, "cell 1 1");
		
		JRadioButton nota3 = new JRadioButton("3");
		buttonGroup.add(nota3);
		panel.add(nota3, "cell 2 1");
		
		JRadioButton nota4 = new JRadioButton("4");
		buttonGroup.add(nota4);
		panel.add(nota4, "cell 3 1");
		
		JRadioButton nota5 = new JRadioButton("5");
		buttonGroup.add(nota5);
		panel.add(nota5, "cell 4 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 184, 307, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][]", "[]"));
		
		JButton endBtn = new JButton("Finalizar Corrida");
		endBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nota1.isSelected())
				{
					Corrida_Controller.getCorrida().getTaxi().recebePonto(1);
				}
				else if(nota2.isSelected()) 
				{
					Corrida_Controller.getCorrida().getTaxi().recebePonto(2);
				}
				else if(nota3.isSelected()) 
				{
					Corrida_Controller.getCorrida().getTaxi().recebePonto(3);
				}
				else if(nota4.isSelected()) 
				{
					Corrida_Controller.getCorrida().getTaxi().recebePonto(4);
				}
				else if(nota5.isSelected()) 
				{
					Corrida_Controller.getCorrida().getTaxi().recebePonto(5);
				}
				
				Corrida_Controller.reset();
				
				FrameController.getClienteLandPage().setVisible(true);
				dispose();
			}
		});
		panel_1.add(endBtn, "cell 3 0");
	}
}
