package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;

import control.Cliente_Controller;
import control.Corrida_Controller;
import control.Login_Controller;
import control.Taxi_Controller;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

public class TaxiLandPage extends JFrame {

	private JPanel contentPane;
	private boolean visivel = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiLandPage frame = new TaxiLandPage();
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
	public TaxiLandPage() {
		setTitle("Vou de Taxi ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 575, 55);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JToggleButton tglbtnVisible = new JToggleButton("Invisivel");
		tglbtnVisible.addItemListener(new ItemListener() {
			@Override
			   public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			    	  
			    	  tglbtnVisible.setText("Visivel");
			    	  visivel=true;
			    	  Taxi_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).setVisible(visivel);
			    	  try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	  Corrida_Controller.CriarCorridaTaxi();
						
						
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			    	  tglbtnVisible.setText("Invisivel");
			    	  Taxi_Controller.busca("", Login_Controller.getUsuario().getUsuario(), "").get(0).setVisible(visivel);
			    	  visivel=false;
			      }
			   }
			});
		panel.add(tglbtnVisible, "cell 0 0,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 575, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 325, 575, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][]", "[]"));
		
		JButton logoffBtn = new JButton("Logoff");
		panel_2.add(logoffBtn, "cell 18 0");
	}
}
