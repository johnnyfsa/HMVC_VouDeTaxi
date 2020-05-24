package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Cliente_Controller;
import control.FrameController;
import control.Login_Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ClienteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTf;
	private JTextField cpfTf;
	private JTextField userTf;
	private JPasswordField passwordField;
	private JPasswordField confirmPswdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastro frame = new ClienteCadastro(false);
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
	public ClienteCadastro(boolean delete) {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 201);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][grow][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 3,alignx trailing");
		
		nomeTf = new JTextField();
		panel.add(nomeTf, "cell 1 3 5 1,growx");
		nomeTf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 5,alignx trailing");
		
		cpfTf = new JTextField();
		panel.add(cpfTf, "cell 1 5 5 1,growx");
		cpfTf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 7,alignx trailing");
		
		userTf = new JTextField();
		panel.add(userTf, "cell 1 7 5 1,growx");
		userTf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 9,alignx trailing");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 9,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 11,alignx trailing");
		
		confirmPswdField = new JPasswordField();
		panel.add(confirmPswdField, "cell 1 11,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 223, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nome, cpf, usuario; 
				String senha =""; 
				String confirmar ="";
				nome = nomeTf.getText();
				cpf = cpfTf.getText();
				usuario = userTf.getText();
				senha = passwordField.getText();
				confirmar = confirmPswdField.getText();
				if(nome.isEmpty()|| cpf.isEmpty()|| usuario.isEmpty()|| senha.isEmpty()|| confirmar.isEmpty()) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Campo obrigatório em branco");
				}
				else if(!senha.equals(confirmar)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Senha e confirmação não coincidem");
				}
				else if(!validaCpf(cpf)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"CPF inválido");
				}
				else if(Cliente_Controller.busca("", usuario, "").isEmpty() && Cliente_Controller.busca("", "", cpf).isEmpty()) 
				{
					Cliente_Controller.adicionar(nome, usuario, senha, cpf);
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cadastro efetuado com sucesso!");
					FrameController.resetFrames();
					FrameController.getLoginView().setVisible(true);
					dispose();
					
				}
				else 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente Já Cadastrado no sistema");
				}
			}
		});
		panel_1.add(confirmBtn, "cell 0 0");
		
		JButton deleteBtn = new JButton("Delete");
		panel_1.add(deleteBtn, "cell 4 0");
		if(delete == true) 
		{
			deleteBtn.setEnabled(true);
		}
		else{
			deleteBtn.setEnabled(false);
		}
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameController.getCadastroPickFrame().setVisible(true);
				dispose();
			}
		});
		panel_1.add(cancelBtn, "cell 8 0");
	}
	
	
	
	public ClienteCadastro() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 201);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][grow][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		
		String Nome = Cliente_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).getNome();
		String CPF = Cliente_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).getCpf();
		String Usuario =Cliente_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).getUsuario();
		String Senha = Cliente_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).getSenha();
		
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 3,alignx trailing");
		
		nomeTf = new JTextField();
		panel.add(nomeTf, "cell 1 3 5 1,growx");
		nomeTf.setColumns(10);
		nomeTf.setText(Nome);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		panel.add(lblNewLabel_1, "cell 0 5,alignx trailing");
		
		cpfTf = new JTextField();
		panel.add(cpfTf, "cell 1 5 5 1,growx");
		cpfTf.setColumns(10);
		cpfTf.setText(CPF);
		cpfTf.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 7,alignx trailing");
		
		userTf = new JTextField();
		panel.add(userTf, "cell 1 7 5 1,growx");
		userTf.setColumns(10);
		userTf.setText(Usuario);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 9,alignx trailing");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 9,growx");
		passwordField.setText(Senha);
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 11,alignx trailing");
		
		confirmPswdField = new JPasswordField();
		panel.add(confirmPswdField, "cell 1 11,growx");
		confirmPswdField.setText(Senha);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 223, 414, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
		
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nome, cpf, usuario; 
				String senha =""; 
				String confirmar ="";
				nome = nomeTf.getText();
				cpf = cpfTf.getText();
				usuario = userTf.getText();
				senha = passwordField.getText();
				confirmar = confirmPswdField.getText();
				if(nome.isEmpty()|| cpf.isEmpty()|| usuario.isEmpty()|| senha.isEmpty()|| confirmar.isEmpty()) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Campo obrigatório em branco");
				}
				else if(!senha.equals(confirmar)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Senha e confirmação não coincidem");
				}
				else if(!validaCpf(cpf)) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"CPF inválido");
				}
				else if(Cliente_Controller.busca("", usuario, "").isEmpty()) 
				{
					Cliente_Controller.editar(CPF, nome, usuario, senha);
					JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente efetivamente editado no sistema");
				}
				else if(!Cliente_Controller.busca("", usuario, "").isEmpty()) 
				{
					if(usuario.equals(Usuario)) 
					{
						Cliente_Controller.editar(CPF, nome, usuario, senha);
						JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente efetivamente editado no sistema");
					}
					else 
					{
						JOptionPane.showMessageDialog(FrameController.getClienteCadastro(),"Cliente Já Cadastrado no sistema");
					}
				}

			}
		});
		panel_1.add(confirmBtn, "cell 0 0");
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente_Controller.remover(Nome, Usuario, CPF);
				FrameController.resetFrames();
				FrameController.getLoginView().setVisible(true);
				dispose();
			}
		});
		panel_1.add(deleteBtn, "cell 4 0");
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameController.resetFrames();
				FrameController.getClienteLandPage().setVisible(true);
				dispose();
			}
		});
		panel_1.add(cancelBtn, "cell 8 0");
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
