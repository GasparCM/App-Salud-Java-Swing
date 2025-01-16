package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Actividades.*;
import Principal.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

//si tengo un cliente en la ventana como esre caso, si hago cli.set algo camboi algun valor, en el array donde se a guardado este cliente
//previamente tmbien cambia o no y tengo k hacer siempre array.get i cambiarlo desde ahi ?


public class CambiarContrasenya extends JFrame implements ActionListener{

	/*****ATRIBUTOS*****/

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField pswNueva;
	private JPasswordField pswNuevaRep;
	private JLabel pswActual;
	private  Repositorio repo;
	private  Cliente cli;
	private JButton btnListo, btnSalir;
	 
	
	/*****CONSTRUCTORES*****/

	public CambiarContrasenya(Repositorio repo,Cliente cli) {
		
		this.cli=cli;
		this.repo=repo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarComponentes();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA CAMBIAR CONTRASEÑA");
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
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(177, 215, 85, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		
		btnListo = new JButton("LISTO");
		btnListo.setBounds(177, 188, 85, 21);
		contentPane.add(btnListo);
		btnListo.addActionListener(this);
		
		JLabel lblRepiteNuevaContrasenya = new JLabel("Repite Nueva Contrasenya");
		lblRepiteNuevaContrasenya.setBounds(166, 140, 124, 28);
		contentPane.add(lblRepiteNuevaContrasenya);
		
		JLabel lblNuevaContrasenya = new JLabel("Nueva Contrasenya");
		lblNuevaContrasenya.setBounds(178, 103, 112, 28);
		contentPane.add(lblNuevaContrasenya);
		
		pswActual = new JLabel("Contrasenya Actual");
		pswActual.setBounds(178, 63, 112, 28);
		contentPane.add(pswActual);
		
		pswNueva = new JPasswordField();
		pswNueva.setBounds(178, 126, 84, 19);
		contentPane.add(pswNueva);
		
		pswNuevaRep = new JPasswordField();
		pswNuevaRep.setBounds(182, 161, 84, 19);
		contentPane.add(pswNuevaRep);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 88, 84, 19);
		contentPane.add(passwordField);
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\fondo-login-web.jpg"));
		lblInicio.setBounds(136, 63, 184, 184);
		contentPane.add(lblInicio);
		
		JLabel lbFondo = new JLabel("");
		lbFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lbFondo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\Desktop\\fotos poo - copia\\vecteezy_abstract-geometric-background-illustration-in-flat-style_.jpg"));
		lbFondo.setBounds(0, -29, 643, 369);
		contentPane.add(lbFondo);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (btnListo==e.getSource()) {
			//si la contraseña actual que ingresamos es correcta
			if (this.repo.getJugadorArray(this.repo.devolverIndiceJugador(this.cli.getAlias())).correctPassword(this.passwordField.getText())==true) {
				//si la contraseña nueva coincide en los dos passwordfields
				if (this.pswNueva.getText().equals(this.pswNuevaRep.getText())) {
					
					try {
							//comprobamos que la contrasña cumple con los requisitos
						 	cli.comprobarPassword(this.pswNueva.getText());
						 	//cambiamos la contraseña
						 	this.repo.getJugadorArray(this.repo.devolverIndiceJugador(this.cli.getAlias())).cambiarPassword(this.pswNueva.getText());
							
						 	JOptionPane.showMessageDialog(null, "La contraseña a sido cambiada correctamente");
							//persistimos en el array
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
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
		}
	}
}
