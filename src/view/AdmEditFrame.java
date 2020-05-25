package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Adm_Controller;
import control.FrameController;
import control.Login_Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmEditFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTf;
	private JTextField userTf;
	private JPasswordField passwordField;
	private JPasswordField confirmField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmEditFrame frame = new AdmEditFrame();
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
	public AdmEditFrame() {
		
		
		String Nome, Usuario, Senha;
		Nome = Login_Controller.getUsuario().getNome();
		Usuario = Login_Controller.getUsuario().getUsuario();
		Senha = Login_Controller.getUsuario().getSenha();
		
		
		
		setTitle("Edicao de Conta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 201);
		contentPane_1.add(panel);
		panel.setLayout(new MigLayout("", "[80px][229px]", "[20px][20px][20px][20px][20px]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "cell 0 1,alignx right,aligny center");
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setText(Nome);
		panel.add(nameTf, "cell 1 1,growx,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel.add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		userTf = new JTextField();
		userTf.setColumns(10);
		userTf.setText(Usuario);
		panel.add(userTf, "cell 1 2,growx,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		panel.add(lblNewLabel_3, "cell 0 3,alignx right,aligny center");
		
		passwordField = new JPasswordField();
		passwordField.setText(Senha);
		panel.add(passwordField, "cell 1 3,growx,aligny top");
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha");
		panel.add(lblNewLabel_4, "cell 0 4,alignx left,aligny center");
		
		confirmField = new JPasswordField();
		confirmField.setText(Senha);
		panel.add(confirmField, "cell 1 4,growx,aligny top");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 223, 414, 51);
		contentPane_1.add(panel_1);
		
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String Nome, Usuario, Senha, Confirma;
				Nome = nameTf.getText();
				Usuario = userTf.getText();
				Senha = passwordField.getText();
				Confirma = confirmField.getText();
				
				if(Confirma.equals(Senha)) 
				{
					Adm_Controller.editar( Nome, Usuario, Senha);
					JOptionPane.showMessageDialog(FrameController.getAdmEditFrame(),"Cadastro Editado com sucesso");
					FrameController.getAdmLandPage().setVisible(true);
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(FrameController.getAdmEditFrame(),"Senhas não coincidem");
				}
				
				
				
			}
		});
		confirmBtn.setBounds(7, 7, 79, 23);
		panel_1.add(confirmBtn);
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getAdmLandPage().setVisible(true);
				dispose();
			}
		});
		cancelBtn.setBounds(331, 7, 75, 23);
		panel_1.add(cancelBtn);
	}

}
