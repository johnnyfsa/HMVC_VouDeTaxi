package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.FrameController;
import control.Taxi_Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxiCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTF;
	private JTextField cpfTF;
	private JTextField usuarioTF;
	private JTextField senhaTF;
	private JTextField csenhaTF;
	private JTextField modeloTF;
	private JTextField corTF;
	private JTextField placaTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiCadastro frame = new TaxiCadastro();
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
	public TaxiCadastro() {
		setTitle("Cadastro de Taxista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 294);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[80px][229px]", "[20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
		
		nomeTF = new JTextField();
		panel.add(nomeTF, "cell 1 0,growx,aligny top");
		nomeTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
		
		cpfTF = new JTextField();
		panel.add(cpfTF, "cell 1 1,growx,aligny top");
		cpfTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		usuarioTF = new JTextField();
		panel.add(usuarioTF, "cell 1 2,growx,aligny top");
		usuarioTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 3,alignx right,aligny center");
		
		senhaTF = new JTextField();
		panel.add(senhaTF, "cell 1 3,growx,aligny top");
		senhaTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 4,alignx left,aligny center");
		
		csenhaTF = new JTextField();
		panel.add(csenhaTF, "cell 1 4,growx,aligny top");
		csenhaTF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de carro");
		panel.add(lblNewLabel_5, "cell 0 5,alignx right,aligny center");
		
		modeloTF = new JTextField();
		panel.add(modeloTF, "cell 1 5,growx,aligny top");
		modeloTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cor");
		panel.add(lblNewLabel_6, "cell 0 6,alignx right,aligny center");
		
		corTF = new JTextField();
		panel.add(corTF, "cell 1 6,alignx left,aligny top");
		corTF.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Placa");
		panel.add(lblNewLabel_7, "cell 0 7,alignx right,aligny center");
		
		placaTF = new JTextField();
		panel.add(placaTF, "cell 1 7,alignx left,aligny top");
		placaTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 316, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[79px][75px][][][][][][][][]", "[23px]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Taxi_Controller.busca("", usuarioTF.getText(), cpfTF.getText()).isEmpty())
				{
					Taxi_Controller.adicionar(nomeTF.getText(), usuarioTF.getText(), senhaTF.getText(), cpfTF.getText());
					JOptionPane.showMessageDialog(FrameController.getTaxiCadastro(),"Cadastro de taxista efetuado com sucesso");
				}
				else 
				{
					JOptionPane.showMessageDialog(FrameController.getTaxiCadastro(),"Já existe um taxista com esses dados");
				}
			}
		});
		panel_1.add(confirmBtn, "cell 0 0,alignx left,aligny top");
		
		JButton cancelBtn = new JButton("Cancelar");
		panel_1.add(cancelBtn, "cell 9 0,alignx left,aligny top");
	}

}
