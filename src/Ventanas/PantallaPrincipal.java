package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaPrincipal extends JFrame implements ActionListener{

	/*****ATRIBUTOS*****/
	
	private JPanel contentPane;
	private Repositorio repo;
	private JButton btnAdmin,BotonLogIn,BotonSignUp,BotonSalir;
	private JLabel TituloPantalla;
	private JLabel lblNewLabel;

	/*****CONSTRUCTOR*****/
	public PantallaPrincipal(Repositorio repo) {
		
		this.repo = repo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarComponentes();
		
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA PRINCIPAL");
		//Para que no pueda aumenatr el tamaño de la ventana
		setResizable(false);
		
	}

	/*****METODOS*****/
	
	public void inicializarComponentes() {
		
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TituloPantalla = new JLabel("GASPAR MOTOS");
		TituloPantalla.setForeground(new Color(255, 255, 255));
		TituloPantalla.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		TituloPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		TituloPantalla.setBounds(120, 30, 245, 32);
		contentPane.add(TituloPantalla);
		
		BotonSignUp = new JButton("REGISTRARSE");
		BotonSignUp.setBackground(new Color(255, 255, 255));
		BotonSignUp.setForeground(new Color(0, 0, 0));
		BotonSignUp.setBounds(140, 82, 200, 25);
		contentPane.add(BotonSignUp);
		BotonSignUp.addActionListener(this);
		
		BotonLogIn = new JButton("INICIAR SESION");
		BotonLogIn.setForeground(new Color(0, 0, 0));
		BotonLogIn.setBackground(new Color(255, 255, 255));
		BotonLogIn.setBounds(140, 120, 200, 25);
		contentPane.add(BotonLogIn);
		BotonLogIn.addActionListener(this);

		btnAdmin = new JButton("ADMINISTRADOR");
		btnAdmin.setForeground(new Color(0, 0, 0));
		btnAdmin.setBackground(new Color(255, 255, 255));
		btnAdmin.setBounds(140, 160, 200, 25);
		contentPane.add(btnAdmin);
		btnAdmin.addActionListener(this);
		
		BotonSalir = new JButton("SALIR");
		BotonSalir.setForeground(new Color(0, 0, 0));
		BotonSalir.setBackground(new Color(255, 255, 255));
		BotonSalir.setBounds(140, 195, 200, 25);
		contentPane.add(BotonSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\d751bfab896b48dde5d4a305596941db.jpg"));
		lblNewLabel.setBounds(0, 0, 600, 351);
		contentPane.add(lblNewLabel);
		BotonSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//BTN LOGIN
		if (BotonLogIn==e.getSource()) {
			VentanaLogIn ventanaL = new VentanaLogIn(this.repo);
			ventanaL.setVisible(true);
		}
		///BTN REGISTRARSE
		if (BotonSignUp==e.getSource()) {
			VentanaRegistrarse ventanaR = new VentanaRegistrarse(this.repo);
			ventanaR.setVisible(true);
		}
		//BTN ADMIN
		if (btnAdmin==e.getSource()) {
			VentanaAdmin venAdm = new VentanaAdmin(repo);
			venAdm.setVisible(true);
		}
		//BTN SALIR
		if (BotonSalir==e.getSource()) {
			this.setVisible(false);
			System.exit(ABORT);
		}
		
		
	}
}
