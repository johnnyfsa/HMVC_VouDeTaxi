package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.Corrida_Controller;
import control.FrameController;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ClienteLandPage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private MaskFormatter data;
	private MaskFormatter hora;
	private MaskFormatter latitudeMask;
	private MaskFormatter longitudeMask;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteLandPage frame = new ClienteLandPage();
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
	public ClienteLandPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(351, 11, 106, 41);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton clienteEditBtn = new JButton("Minha Conta");
		panel.add(clienteEditBtn, "cell 1 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 228, 447, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[][]"));
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 119, 447, 98);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][75.00][52.00][70.00][][][][][grow][][grow]", "[][][]"));
		
		JRadioButton rdbtnNow = new JRadioButton("Pra Agora");
		rdbtnNow.setSelected(true);
		panel_2.add(rdbtnNow, "cell 0 0");
		buttonGroup.add(rdbtnNow);
		
		JRadioButton rdbtnLater = new JRadioButton("Para Depois");
		panel_2.add(rdbtnLater, "cell 0 1");
		buttonGroup.add(rdbtnLater);
		
		JLabel lblNewLabel_2 = new JLabel("Quando?");
		panel_2.add(lblNewLabel_2, "cell 0 2");
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		panel_2.add(lblNewLabel_3, "cell 1 2");
		
		
		try {
			 data = new MaskFormatter("##-##-####");
			 hora = new MaskFormatter("##:##");
			 longitudeMask = new MaskFormatter("#####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFormattedTextField dateFtf = new JFormattedTextField(data);
		dateFtf.setEditable(false);
		panel_2.add(dateFtf, "cell 2 2,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Hora");
		panel_2.add(lblNewLabel_4, "cell 3 2,alignx trailing");
		
		JFormattedTextField hourFtf = new JFormattedTextField(hora);
		hourFtf.setEditable(false);
		panel_2.add(hourFtf, "cell 4 2,growx");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 46, 312, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[][80.00][][85.00,grow]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Latitude");
		panel_3.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		JFormattedTextField latitudeField = new JFormattedTextField(longitudeMask);
		panel_3.add(latitudeField, "flowx,cell 1 0,growx");
		
		JLabel lblNewLabel_5 = new JLabel("Latitude");
		panel_3.add(lblNewLabel_5, "cell 2 0,alignx trailing");
		
		JFormattedTextField latitudeField_1 = new JFormattedTextField(longitudeMask);
		panel_3.add(latitudeField_1, "cell 3 0,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Longitude");
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		JFormattedTextField longitudeField = new JFormattedTextField(longitudeMask);
		panel_3.add(longitudeField, "cell 1 1,growx");
		
		JLabel lblNewLabel_5_1 = new JLabel("Longitude");
		panel_3.add(lblNewLabel_5_1, "cell 2 1,alignx trailing");
		
		JFormattedTextField longitudeField_1 = new JFormattedTextField(longitudeMask);
		panel_3.add(longitudeField_1, "cell 3 1,growx");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(351, 333, 106, 41);
		contentPane.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton btnNewButton_1 = new JButton("Logoff");
		panel_4.add(btnNewButton_1, "cell 1 0");
		
		rdbtnNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateFtf.setEditable(false);
				hourFtf.setEditable(false);
			}
		});
		
		rdbtnLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateFtf.setEditable(true);
				hourFtf.setEditable(true);
			}
		});
		
		JButton generateRaceBtn = new JButton("Gerar Corrida");
		generateRaceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double[] partida, chegada;
				partida= new double[2];
				chegada = new double[2];
				String ltt1, ltt2, lgt1, lgt2;
				
				ltt1 = latitudeField.getText().replaceAll("\\D","");
				ltt2 = latitudeField_1.getText().replaceAll("\\D","");
				
				lgt1 = longitudeField.getText().replaceAll("\\D","");
				lgt2 = longitudeField.getText().replaceAll("\\D","");
				
				
				if(ltt1.isEmpty() || ltt2.isEmpty()|| lgt1.isEmpty()|| lgt2.isEmpty()) 
				{
					JOptionPane.showMessageDialog(FrameController.getClienteLandPage(),"Campo Obrigatório Vazio");
				}
				else 
				{
					partida[0] = Double.parseDouble(latitudeField.getText());
					partida[1] = Double.parseDouble(longitudeField.getText());
					
					chegada[0] = Double.parseDouble(latitudeField_1.getText());
					chegada[1] = Double.parseDouble(longitudeField_1.getText());
					
					if(rdbtnNow.isSelected()) 
					{
						Corrida_Controller.CriarCorrida(partida, chegada, LocalDateTime.now());
					}
					else 
					{
						String data, hora;
						data = dateFtf.getText();
						hora = hourFtf.getText();
						
						String aux = data.replaceAll("\\D","");
						String aux2 = hora.replaceAll("\\D","");
						
						if(aux.isEmpty()||aux2.isEmpty()) 
						{
							JOptionPane.showMessageDialog(FrameController.getClienteLandPage(),"Campo Obrigatório Vazio");
						}
						else 
						{
							String datahora = data + " " + hora;
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
							LocalDateTime dateTime = LocalDateTime.parse(datahora, formatter);
							long diferenca = Duration.between(LocalDateTime.now(),dateTime ).toMinutes();
							if(diferenca<30) 
							{
								JOptionPane.showMessageDialog(FrameController.getClienteLandPage(),"Agendamentos só podem ser realizados com até 30 min de antecedência");
							}
						}
					}
				}
				
			}
		});
		panel_1.add(generateRaceBtn, "cell 6 1,growx");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 312, 24);
		contentPane.add(panel_5);
		panel_5.setLayout(new MigLayout("", "[][][][][]", "[]"));
		
		JLabel lblNewLabel_6 = new JLabel("Partida");
		panel_5.add(lblNewLabel_6, "cell 0 0");
		
		JLabel lblNewLabel_7 = new JLabel("Chegada");
		panel_5.add(lblNewLabel_7, "cell 4 0,alignx right");
		
		
		
	}
}
