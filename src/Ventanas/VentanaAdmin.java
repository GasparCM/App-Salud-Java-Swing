package Ventanas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaAdmin extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JButton btnGenInforCli,btnSalir;
	private  Repositorio repos;
	

	
	public VentanaAdmin(Repositorio repo) {
		this.repos=repo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA ADMIN");
		setResizable(false);
		iniciaComp();
				
	}
	
	public void iniciaComp() {
		
		//btnsalir
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(167, 184, 169, 21);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		//btnGenInforCli
		btnGenInforCli = new JButton("GENERAR INFORME CLIENTES");
		btnGenInforCli.setBackground(new Color(255, 255, 255));
		btnGenInforCli.setBounds(167, 145, 169, 21);
		contentPane.add(btnGenInforCli);
		btnGenInforCli.addActionListener(this);
		
		//labelFondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\vecteezy_abstract-geometric-background-illustration-in-flat-style_.jpg"));
		lblFondo.setBounds(0, 0, 511, 317);
		contentPane.add(lblFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnGenInforCli==e.getSource()) {
			this.repos.imprimirRepo();
		}
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
		}
	}
}
