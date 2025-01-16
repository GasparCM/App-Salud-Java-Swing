package Ventanas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Cliente;
import Principal.ClienteVip;
import Principal.Persistencia;
import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class CambiarPrime extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275752235908241593L;
	private JPanel contentPane;
	private Repositorio repo;
	private Cliente cli;
	private JPasswordField pswFil2,pswViejFiel,pswFil;
	private JSpinner spinDuracion;
	private JButton btnListo,btnSalir;
	private JLabel lblpastPas;
	private JLabel lblNewPas;
	private JLabel lblNewPas2;
	private JLabel lblCuadrado;
	private JLabel lblDuracion;
	/**
	 * Create the frame.
	 */
	public CambiarPrime(Repositorio repo,Cliente cli) {
		
		this.repo = repo;
		this.cli = cli;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		inicialComp();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA CAMBIAR A PREMIUM");
		setResizable(false);
				
		}
	public void inicialComp() {
		
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(246, 207, 74, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		lblNewPas2 = new JLabel("Contraseña Nueva");
		lblNewPas2.setForeground(new Color(0, 0, 0));
		lblNewPas2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewPas2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPas2.setBounds(191, 115, 107, 13);
		contentPane.add(lblNewPas2);
		
		lblDuracion = new JLabel("Duracion Cuenta");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setForeground(new Color(0, 0, 0));
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDuracion.setBounds(191, 162, 107, 13);
		contentPane.add(lblDuracion);
		
		spinDuracion = new JSpinner();
		spinDuracion.setModel(new SpinnerListModel(new String[] {"Mensual", "Anual", "Indefinida"}));
		spinDuracion.setBounds(191, 176, 107, 21);
		contentPane.add(spinDuracion);
		
		lblpastPas = new JLabel("Contraseña Actual");
		lblpastPas.setForeground(new Color(0, 0, 0));
		lblpastPas.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblpastPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblpastPas.setBounds(191, 38, 107, 13);
		contentPane.add(lblpastPas);
		
		lblNewPas = new JLabel("Contraseña Nueva");
		lblNewPas.setForeground(new Color(0, 0, 0));
		lblNewPas.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPas.setBounds(191, 77, 107, 13);
		contentPane.add(lblNewPas);
		
		btnListo = new JButton("LISTO");
		btnListo.setBounds(169, 207, 74, 21);
		contentPane.add(btnListo);
		btnListo.addActionListener(this);
		
		pswFil = new JPasswordField();
		pswFil.setBounds(191, 92, 107, 21);
		contentPane.add(pswFil);
		
		pswViejFiel = new JPasswordField();
		pswViejFiel.setBounds(191, 53, 107, 21);
		contentPane.add(pswViejFiel);
		
		pswFil2 = new JPasswordField();
		pswFil2.setBounds(191, 134, 107, 21);
		contentPane.add(pswFil2);
		
		lblCuadrado = new JLabel("");
		lblCuadrado.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\vecteezy_abstract-geometric-background-illustration-in-flat-style_.jpg"));
		lblCuadrado.setBounds(154, 28, 177, 211);
		contentPane.add(lblCuadrado);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\8172f32cc85e02fe8c7cec5f5fd176fb.jpg"));
		lblFondo.setBounds(0, 0, 521, 319);
		contentPane.add(lblFondo);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//si pulsamos el boton listo
		
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
	
		}
		if (btnListo==e.getSource()) {
			//si la contraseña actual que ingresamos es correcta
			if (this.repo.getJugadorArray(this.repo.devolverIndiceJugador(this.cli.getAlias())).correctPassword(this.pswViejFiel.getText())==true) {
				//si la contraseña nueva coincide en los dos passwordfields
				if (this.pswFil.getText().equals(this.pswFil2.getText())) {
					
					try {
						//creamos el cliente vip
						Cliente clien = new ClienteVip(this.cli,this.pswFil.getText()); 
						
						JOptionPane.showMessageDialog(null, "Ya eres vip");
						
						//borramos de la lista al cliente normal
						this.repo.devolverArray().remove(this.repo.devolverIndiceJugador(this.cli.getAlias()));
						
						//anyadimos al array el cliente vip
						this.repo.anyadirPersona(clien);
						
						Persistencia.persistArray(this.repo.devolverArray());
						
						this.setVisible(false);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "La contraseña nueva no coincide en ambos slots");
				}
			} 
			else {
				JOptionPane.showMessageDialog(null, "La contraseña actual no es correcta");
				
			}
		}
	}
}
