package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Cliente;
import Principal.FactorActividad;
import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class VentanaRegistrarse extends JFrame implements ActionListener{

	/*****ATRIBUTOS*****/

	private Repositorio repo;
	private JPanel contentPane;
	private JTextField textAlias,textApellido1,textPassword,textFechaNac,textApellido2,textNombre;
	private JButton btnSalir,btnEntrar;
	private JLabel LabelAlias;
	private JLabel LabelFoto;
	private Duration duracion;
	private JSpinner spinnerFacAc;
	private boolean sexoBool;
	private JSpinner spinnerSexo;
	private JLabel lblSexo;
	private JTextField txtAltura,txtPeso;
	private Cliente cli;
	private FactorActividad factorAc;
	private LocalDate fechaNac;
	private int edad;

	/*****CONSTRUCOTRES*****/
	public VentanaRegistrarse(Repositorio repo) {
		
		this.repo=repo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializarComponentes();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA REGISTRARSE");
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
		
		JLabel lblM = new JLabel("(en m y .)");
		lblM.setForeground(Color.WHITE);
		lblM.setBounds(357, 110, 56, 13);
		contentPane.add(lblM);
		
		JLabel lblKg = new JLabel("(en kg)");
		lblKg.setForeground(new Color(255, 255, 255));
		lblKg.setBounds(360, 135, 45, 13);
		contentPane.add(lblKg);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(405, 122, 62, 19);
		contentPane.add(txtPeso);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeso.setBounds(362, 125, 45, 13);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAltura.setBounds(362, 99, 45, 13);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(405, 96, 62, 19);
		contentPane.add(txtAltura);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setBounds(362, 75, 45, 13);
		contentPane.add(lblSexo);
		
		spinnerSexo = new JSpinner();
		spinnerSexo.setModel(new SpinnerListModel(new String[] {"HOMBRE", "MUJER"}));
		spinnerSexo.setBounds(405, 72, 71, 20);
		contentPane.add(spinnerSexo);
		
		JLabel lblFactorAct = new JLabel("Factor Actividad");
		lblFactorAct.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFactorAct.setForeground(new Color(255, 255, 255));
		lblFactorAct.setBounds(135, 226, 95, 13);
		contentPane.add(lblFactorAct);
		
		spinnerFacAc = new JSpinner();
		spinnerFacAc.setModel(new SpinnerListModel(new String[] {"sedentaria", "ligera", "moderada", "intensa", "extrema"}));
		spinnerFacAc.setBounds(245, 220, 92, 19);
		contentPane.add(spinnerFacAc);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR CLIENTE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(135, 35, 230, 30);
		contentPane.add(lblNewLabel);
		
		JLabel LabelNombre = new JLabel("Nombre: ");
		LabelNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelNombre.setForeground(new Color(255, 255, 255));
		LabelNombre.setBounds(170, 75, 70, 13);
		contentPane.add(LabelNombre);
		 
		JLabel LabelApellido1 = new JLabel("Apellido 1: ");
		LabelApellido1.setForeground(new Color(255, 255, 255));
		LabelApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelApellido1.setBounds(170, 99, 70, 13);
		contentPane.add(LabelApellido1);
		
		JLabel LabelApellido2 = new JLabel("Apellido 2: ");
		LabelApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelApellido2.setForeground(new Color(255, 255, 255));
		LabelApellido2.setBounds(170, 125, 76, 13);
		contentPane.add(LabelApellido2);
		
		JLabel LabelFecha = new JLabel("Fecha Nacimiento: ");
		LabelFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelFecha.setForeground(new Color(255, 255, 255));
		LabelFecha.setBounds(135, 148, 116, 13);
		contentPane.add(LabelFecha);
		
		JLabel LabelFormato = new JLabel("(dd/mm/yyyy) ");
		LabelFormato.setForeground(new Color(255, 255, 255));
		LabelFormato.setFont(new Font("Tahoma", Font.BOLD, 10));
		LabelFormato.setBounds(148, 159, 82, 10);
		contentPane.add(LabelFormato);
		
		JLabel LabelContrasenya = new JLabel("Contraseña: ");
		LabelContrasenya.setForeground(new Color(255, 255, 255));
		LabelContrasenya.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelContrasenya.setBounds(162, 200, 92, 13);
		contentPane.add(LabelContrasenya);
		
		textNombre = new JTextField();
		textNombre.setBounds(245, 70, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(245, 95, 96, 19);
		contentPane.add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(245, 120, 96, 19);
		contentPane.add(textApellido2);
		
		textFechaNac = new JTextField();
		textFechaNac.setColumns(10);
		textFechaNac.setBounds(245, 145, 96, 19);
		contentPane.add(textFechaNac);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(245, 195, 96, 19);
		contentPane.add(textPassword);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(161, 249, 85, 21);
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(256, 249, 85, 21);
		contentPane.add(btnSalir);
		
		textAlias = new JTextField();
		textAlias.setColumns(10);
		textAlias.setBounds(245, 170, 96, 19);
		contentPane.add(textAlias);
		
		LabelAlias = new JLabel("Alias:  ");
		LabelAlias.setForeground(new Color(255, 255, 255));
		LabelAlias.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelAlias.setBounds(170, 175, 92, 13);
		contentPane.add(LabelAlias);
		
		LabelFoto = new JLabel("");
		LabelFoto.setVerticalAlignment(SwingConstants.TOP);
		LabelFoto.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\7ca595fef959a2431bbe75fb9304b368.jpg"));
		LabelFoto.setBounds(-14, -136, 500, 439);
		contentPane.add(LabelFoto);
		btnSalir.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//si pulsamos el boton entrar
		if (btnEntrar==e.getSource()) {
				//si no se repite el alias en el arraylist de personas
				if (repo.seRepiteAlias(textAlias.getText())==false) {
					//si la fecha es menor a la actual y es introducida en el formato correcto
					if (comprobarEdad(textFechaNac.getText())==true) {
						
						try {
							setSex();
							setterFactAct();
							cli = new Cliente(textAlias.getText(), textPassword.getText(),this.fechaNac,this.sexoBool,Double.parseDouble(this.txtPeso.getText()),Double.parseDouble(this.txtAltura.getText()),this.factorAc);			
							cli.setNombre(textNombre.getText());
							cli.setEdad(this.edad);
							cli.setApellido1(this.textApellido1.getText());
							cli.setApellido2(this.textApellido2.getText());
							//repo.anyadirPersona(cli);
							
							VentanaAppSalud vent = new  VentanaAppSalud(this.repo,this.cli);
							vent.setVisible(true);
							this.setVisible(false);
					
						} catch (DateTimeException e1) {
							System.out.println("juder");	//porque salta la excepcion ?
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						 catch (Exception e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}	
				}
		}
		//si pulsamos el boton salir
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
		}
	}
	/**
	 * Metodo que se encarga de registrar a la persona y hacer las comprobaciones pertinetes,
	 * que no se repita ningun jugador con el mismo alias, que la fecha de nacimineto sea mayor a la actual, y crea un cliente, lo anyade al array 
	 *  y crea la ventana principal de la app
	 */
	/*public void signCli() {
		//si no se repite el alias en el arraylist de personas
		if (repo.seRepiteAlias(textAlias.getText())==false) {
			//si la fecha es menor a la actual y es introducida en el formato correcto
			if (comprobarEdad(textFechaNac.getText())==true) {
				
				try {
					setSex();
					setterFactAct();
					cli = new Cliente(textAlias.getText(), textPassword.getText(),this.fechaNac,this.sexoBool,Double.parseDouble(this.txtPeso.getText()),Double.parseDouble(this.txtAltura.getText()),this.factorAc);			
					cli.setNombre(textNombre.getText());
					cli.setEdad(this.edad);
					cli.setApellido1(this.textApellido1.getText());
					cli.setApellido2(this.textApellido2.getText());
					repo.anyadirPersona(cli);
					
					VentanaAppSalud vent = new  VentanaAppSalud(this.repo,this.cli);
					vent.setVisible(true);
					this.setVisible(false);
			
				} catch (DateTimeException e1) {
					System.out.println("juder");	//porque salta la excepcion ?
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}	
		}
		
		
	}*/
	
	/**
	 * Metodo que comprueba si el cliente es hombre o mujer y lo asigna a un avariable booleana
	 * si es hombre = true si es mujer = false.
	 */
	public void setSex() {
		
		if (this.spinnerSexo.getModel().getValue().toString().equalsIgnoreCase("HOMBRE")) {
			this.sexoBool=true;
		}
		if (this.spinnerSexo.getModel().getValue().toString().equalsIgnoreCase("MUJER")) {
			this.sexoBool=false;
		}
	}
	
	/**
	 * Metodo que compruea que valor hay en el escaner y le da ese valor al atributo factorAct de esta ventana que 
	 * posteriormente usaremos para crear al cliente
	 */
	public void setterFactAct() {
			
		if (this.spinnerFacAc.getModel().getValue().toString().equalsIgnoreCase("sedentaria")) {
			this.factorAc=FactorActividad.sedentaria;
		}
		if (this.spinnerFacAc.getModel().getValue().toString().equalsIgnoreCase("ligera")) {
			this.factorAc=FactorActividad.actividadLigera;
		}
		if (this.spinnerFacAc.getModel().getValue().toString().equalsIgnoreCase("moderada")) {
			this.factorAc=FactorActividad.actividadModerada;	
		}
		if (this.spinnerFacAc.getModel().getValue().toString().equalsIgnoreCase("intensa")) {
			this.factorAc=FactorActividad.actividadIntensa;
		}
		if (this.spinnerFacAc.getModel().getValue().toString().equalsIgnoreCase("extrema")) {
			this.factorAc=FactorActividad.actividadExtrema;			
		}	
	}
	
	/**
	 * Metodo que comprueba que la fecha introducida es menor a la actual, comprueba el formato, y calcula la edad de la persona
	 * @param 
	 * @return true si es correcta la fecha i formato, false si no
	 */
	public boolean comprobarEdad(String s) {
		
		boolean tieneEdad=false;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateHoy = LocalDate.now();
	
		try {
				this.fechaNac = LocalDate.parse(s, formato);	
				//si la fecha es anterior a la actual
				if (fechaNac.isBefore(dateHoy)==true) {
					
					this.edad=Period.between(fechaNac,dateHoy).getYears();
					tieneEdad=true;
				}
				else {
					JOptionPane.showMessageDialog(null, "La fecha debe ser antes que la actual");
				}
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "El formato introducido no es el correcto");
			
		}
		 catch (DateTimeException e) {
				JOptionPane.showMessageDialog(null, "MECAGENDEU");
				
		}

		return tieneEdad;
	}
}
