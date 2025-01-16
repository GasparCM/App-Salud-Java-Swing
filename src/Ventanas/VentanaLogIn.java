package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VentanaLogIn extends JFrame implements ActionListener{

	/*****ATRIBUTOS*****/


	private JPanel contentPane;
	private JTextField textAlias;
	private JLabel LabelPassword,LabelLogin,LabelAlias;
	private JPasswordField passwordField;
	private JButton btnEntrarLogIn;
	private JButton btnSalir;
	private JLabel LabelImagen;
	private Repositorio repo;

	/*****CONSTRUCTORES*****/
	public VentanaLogIn(Repositorio repo) {
		
		this.repo=repo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarComponentes();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA LOGIN");
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
		
		LabelLogin = new JLabel("LOG IN");
		LabelLogin.setForeground(new Color(255, 255, 255));
		LabelLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		LabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLogin.setBounds(51, 32, 294, 25);
		contentPane.add(LabelLogin);
		
		LabelAlias = new JLabel("Alias: ");
		LabelAlias.setBackground(new Color(0, 0, 0));
		LabelAlias.setForeground(new Color(255, 255, 255));
		LabelAlias.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelAlias.setBounds(101, 86, 57, 25);
		contentPane.add(LabelAlias);
		
		textAlias = new JTextField();
		textAlias.setBounds(150, 90, 96, 19);
		contentPane.add(textAlias);
		textAlias.setColumns(10);
		
		LabelPassword = new JLabel("Password: ");
		LabelPassword.setBackground(new Color(0, 0, 0));
		LabelPassword.setForeground(new Color(255, 255, 255));
		LabelPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelPassword.setBounds(67, 122, 73, 13);
		contentPane.add(LabelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 120, 96, 19);
		contentPane.add(passwordField);
		
		btnEntrarLogIn = new JButton("Entrar");
		btnEntrarLogIn.setBounds(155, 150, 85, 20);
		contentPane.add(btnEntrarLogIn);
		btnEntrarLogIn.addActionListener(this);
	
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(155, 175, 85, 20);
		contentPane.add(btnSalir);
		
		LabelImagen = new JLabel("");
		LabelImagen.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\c406280d81f7e0e32f6b5f3af36d4282.jpg"));
		LabelImagen.setBounds(0, 0, 501, 351);
		contentPane.add(LabelImagen);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnEntrarLogIn==e.getSource()) {
			yaRegistrado();
		}
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
		}
	}

	/**
	 * 
	 * Metodo que comprueba si el jugador ya a sido registrado, pide el alias si es correcto pide la contraseña y si es correcta
	 *  empieza la partida dentro de esta funcion con el jugador que hemos ingresado sus datos 
	 * @return
	 */
	public void yaRegistrado() {
		
		int indice;
		
		//si existe un jugador con ese alias = true
		if (this.repo.existeEnArray(this.textAlias.getText())==true) {
			indice=this.repo.devolverIndiceJugador(this.textAlias.getText());
			//si la contraseña introducida es correcta con la del alias introducido 
			if (this.repo.esContrasenaCorrecta(indice, this.passwordField.getText())==true) {
				VentanaAppSalud vent = new VentanaAppSalud(this.repo,this.repo.getJugadorArray(indice));
				vent.setVisible(true);
				this.setVisible(false);
			}
			
			else{
					
				JOptionPane.showMessageDialog(null, "La contraseña no coincide con la del alias");		
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay ningun usuario con ese alias");
			
		}
	}
}
