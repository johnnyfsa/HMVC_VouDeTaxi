package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Cliente_Controller;
import control.FrameController;
import control.Taxi_Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class EditarTaxi extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTf;
	private JTextField cpfTf;
	private JTextField userTf;
	private JTextField modelTf;
	private JTextField corTf;
	private JTextField placaTf;
	private JPasswordField pswdTf;
	private JPasswordField confirmTf;
	private JTextField corridaTf;
	private JTextField tempoTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarTaxi frame = new EditarTaxi();
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
	
	
	public EditarTaxi(String cpf) {

		long totalTempo = Taxi_Controller.busca("", "", cpf).get(0).getTempoTotal();
		String nome, usuario, senha, modelo, cor, placa;
		int total;
		total = Taxi_Controller.busca("", "", cpf).get(0).getTotalCorridas();
		nome =Taxi_Controller.busca("", "", cpf).get(0).getNome();
		usuario = Taxi_Controller.busca("", "", cpf).get(0).getUsuario();
		senha = Taxi_Controller.busca("", "", cpf).get(0).getSenha();
		modelo = Taxi_Controller.busca("", "", cpf).get(0).getModeloCarro();
		cor = Taxi_Controller.busca("", "", cpf).get(0).getCorCarro();
		placa = Taxi_Controller.busca("", "", cpf).get(0).getPlaca();
		
		
		setTitle("Editar Taxi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 294);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[80px][229px]", "[20px][20px][20px][17px][17px][20px][20px][20px]"));
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
		
		nomeTf = new JTextField();
		nomeTf.setColumns(10);
		panel.add(nomeTf, "cell 1 0,growx,aligny top");
		nomeTf.setText(nome);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		userTf = new JTextField();
		userTf.setColumns(10);
		panel.add(userTf, "cell 1 2,growx,aligny top");
		userTf.setText(usuario);
		
		cpfTf = new JTextField();
		cpfTf.setEditable(false);
		cpfTf.setColumns(10);
		cpfTf.setText(cpf);
		panel.add(cpfTf, "cell 1 1,growx,aligny top");
		
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 3,alignx right,aligny bottom");
		
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 4,alignx left,aligny bottom");
		
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de carro");
		panel.add(lblNewLabel_5, "cell 0 5,alignx right,aligny center");
		
		
		modelTf = new JTextField();
		modelTf.setColumns(10);
		panel.add(modelTf, "cell 1 5,growx,aligny top");	
		modelTf.setText(modelo);
	
		
		JLabel lblNewLabel_6 = new JLabel("Cor");
		panel.add(lblNewLabel_6, "cell 0 6,alignx right,aligny center");
		
		corTf = new JTextField();
		corTf.setColumns(10);
		panel.add(corTf, "cell 1 6,alignx left,aligny top");
		corTf.setText(cor);
		
		JLabel lblNewLabel_7 = new JLabel("Placa");
		panel.add(lblNewLabel_7, "cell 0 7,alignx right,aligny center");
		
		
		placaTf = new JTextField();
		placaTf.setColumns(10);
		panel.add(placaTf, "cell 1 7,alignx left,aligny top");
		placaTf.setText(placa);
		
		pswdTf = new JPasswordField();
		panel.add(pswdTf, "cell 1 3,grow");
		pswdTf.setText(senha);
		
		confirmTf = new JPasswordField();
		panel.add(confirmTf, "cell 1 4,grow");
		confirmTf.setText(senha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 316, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[79px][89px][75px][][][][][]", "[23px]"));
		
		
JButton confirmBtn = new JButton("Confirmar");
		
		panel_1.add(confirmBtn, "cell 0 0,alignx left,aligny top");
		
		confirmBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String Nome, Usuario, Senha, Confirmar, Modelo, Cor, Placa;
				Nome = nomeTf.getText();
				Usuario = userTf.getText();
				Senha = pswdTf.getText();
				Confirmar = confirmTf.getText();
				Modelo = modelTf.getText();
				Cor = corTf.getText();
				Placa = placaTf.getText();
				
				if(Nome.isEmpty()|| cpf.isEmpty()|| Usuario.isEmpty()|| Senha.isEmpty()|| Confirmar.isEmpty()|| Modelo.isEmpty() || Cor.isEmpty()|| Placa.isEmpty()) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Campo obrigat�rio em branco");
				}
				else if(!Senha.equals(Confirmar)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Senha e confirma��o n�o coincidem");
				}
				else if(!validaCpf(cpf)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"CPF inv�lido");
				}
				else if(Taxi_Controller.busca("", Usuario, "").isEmpty()) 
				{
					Taxi_Controller.editar(cpf, Nome, Usuario, Senha  , Modelo, Cor, Placa);
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente efetivamente editado no sistema");
				}
				else if(!Taxi_Controller.busca("", Usuario, "").isEmpty()) 
				{
					if(Usuario.equals(usuario)) 
					{
						Taxi_Controller.editar(cpf, Nome, Usuario, Senha  , Modelo, Cor, Placa);
						JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente efetivamente editado no sistema");
					}
					else 
					{
						JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente J� Cadastrado no sistema");
					}
				}
			}
		});
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(cancelBtn, "cell 7 0,alignx left,aligny top");
		
		
		JLabel lblNewLabel_8 = new JLabel("Corridas Realizadas");
		panel.add(lblNewLabel_8, "cell 0 8,alignx trailing");
		
		corridaTf = new JTextField();
		panel.add(corridaTf, "cell 1 8,growx");
		corridaTf.setColumns(10);
		corridaTf.setText(" "+total);
		corridaTf.setEditable(false);
		
		JLabel lblNewLabel_9 = new JLabel("Tempo Total das Corridas");
		panel.add(lblNewLabel_9, "cell 0 9,alignx trailing");
		
		tempoTf = new JTextField();
		panel.add(tempoTf, "cell 1 9,growx");
		tempoTf.setColumns(10);
		tempoTf.setText("" + totalTempo);
		tempoTf.setEditable(false);
		
		
		
	}
	
	////outro construtor
	
	public EditarTaxi() {
		setTitle("Editar Taxi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 294);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[80px][229px,grow]", "[20px][20px][20px][17px][17px][20px][20px][20px][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
		
		nomeTf = new JTextField();
		nomeTf.setColumns(10);
		panel.add(nomeTf, "cell 1 0,growx,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
		
		cpfTf = new JTextField();
		cpfTf.setText("something");
		cpfTf.setEditable(false);
		cpfTf.setColumns(10);
		panel.add(cpfTf, "cell 1 1,growx,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		userTf = new JTextField();
		userTf.setColumns(10);
		panel.add(userTf, "cell 1 2,growx,aligny top");
		
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 3,alignx right,aligny bottom");
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 4,alignx left,aligny bottom");
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de carro");
		panel.add(lblNewLabel_5, "cell 0 5,alignx right,aligny center");
		
		modelTf = new JTextField();
		modelTf.setColumns(10);
		panel.add(modelTf, "cell 1 5,growx,aligny top");
		
		JLabel lblNewLabel_6 = new JLabel("Cor");
		panel.add(lblNewLabel_6, "cell 0 6,alignx right,aligny center");
		
		corTf = new JTextField();
		corTf.setColumns(10);
		panel.add(corTf, "cell 1 6,alignx left,aligny top");
		
		JLabel lblNewLabel_7 = new JLabel("Placa");
		panel.add(lblNewLabel_7, "cell 0 7,alignx right,aligny center");
		
		placaTf = new JTextField();
		placaTf.setColumns(10);
		panel.add(placaTf, "cell 1 7,alignx left,aligny top");
		
		pswdTf = new JPasswordField();
		panel.add(pswdTf, "cell 1 3,grow");
		
		confirmTf = new JPasswordField();
		panel.add(confirmTf, "cell 1 4,grow");
		
		JLabel lblNewLabel_8 = new JLabel("Corridas Realizadas");
		panel.add(lblNewLabel_8, "cell 0 8,alignx trailing");
		
		corridaTf = new JTextField();
		panel.add(corridaTf, "cell 1 8,growx");
		corridaTf.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Tempo Total das Corridas");
		panel.add(lblNewLabel_9, "cell 0 9,alignx trailing");
		
		tempoTf = new JTextField();
		panel.add(tempoTf, "cell 1 9,growx");
		tempoTf.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 316, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[79px][89px][75px][][][][][]", "[23px]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		
		panel_1.add(confirmBtn, "cell 0 0,alignx left,aligny top");
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(cancelBtn, "cell 7 0,alignx left,aligny top");
	}
	
	public boolean validaCpf(String CPF) 
	{
		
		        // considera-se erro CPF's formados por uma sequencia de numeros iguais
		        if (CPF.equals("00000000000") ||
		            CPF.equals("11111111111") ||
		            CPF.equals("22222222222") || CPF.equals("33333333333") ||
		            CPF.equals("44444444444") || CPF.equals("55555555555") ||
		            CPF.equals("66666666666") || CPF.equals("77777777777") ||
		            CPF.equals("88888888888") || CPF.equals("99999999999") ||
		            (CPF.length() != 11))
		            return(false);
		          
		        char dig10, dig11;
		        int sm, i, r, num, peso;
		          
		        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		        try {
		        // Calculo do 1o. Digito Verificador
		            sm = 0;
		            peso = 10;
		            for (i=0; i<9; i++) {              
		        // converte o i-esimo caractere do CPF em um numero:
		        // por exemplo, transforma o caractere '0' no inteiro 0         
		        // (48 eh a posicao de '0' na tabela ASCII)         
		            num = (int)(CPF.charAt(i) - 48); 
		            sm = sm + (num * peso);
		            peso = peso - 1;
		            }
		          
		            r = 11 - (sm % 11);
		            if ((r == 10) || (r == 11))
		                dig10 = '0';
		            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
		          
		        // Calculo do 2o. Digito Verificador
		            sm = 0;
		            peso = 11;
		            for(i=0; i<10; i++) {
		            num = (int)(CPF.charAt(i) - 48);
		            sm = sm + (num * peso);
		            peso = peso - 1;
		            }
		          
		            r = 11 - (sm % 11);
		            if ((r == 10) || (r == 11))
		                 dig11 = '0';
		            else dig11 = (char)(r + 48);
		          
		        // Verifica se os digitos calculados conferem com os digitos informados.
		            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		                 return(true);
		            else return(false);
		                } catch (InputMismatchException erro) {
		                return(false);
		            }
		        
	}
}
