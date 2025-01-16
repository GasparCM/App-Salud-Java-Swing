package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Actividades.Actividad;
import Actividades.Cycling;
import Actividades.Running;
import Actividades.Swimming;
import Principal.Cliente;
import Principal.Persistencia;
import Principal.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class VentanaRegistrarActividad extends JFrame implements ActionListener {

	/*****ATRIBUTOS*****/

	private JPanel contentPane;
	private  JLabel lblFondo = new JLabel("");
	private Repositorio repo;
	private JButton btnListo,btnActividad,btnSalir;
	private JTextField txtKcalCons,txtDuracion,txtDistancia,txtFechIni;
	private JTextField txtCadenciaCycling;
	private JLabel lblCadencia,lblCadenciaCycling2;
	private JTextField txtNumLargos;
	private JLabel lblNumLargos,lbTipoNatacion;
	private JSpinner spinnerTipoNatacion,spinerTipoActiv;
	private JLabel  CadenciaRunning,lblNumTotPas,lblElevacion,lblRitmo,CadenciaRunning2;
	private JTextField textRitmo,txtElevacion,textNumTotPas,txtCadenciaRunning;
	private Cliente cli;
	private Actividad act;
	private JLabel lblFormato;
	private Duration duracion;
	private Double factorActividad;
	private JTextField txtFcMin;
	private JTextField txtFcMax;
	private JLabel lblFcMin;
	private int elevacion;

	
	/*****CONSTRUCTORES*****/
	public VentanaRegistrarActividad(Repositorio repo,Cliente clie) {
		this.repo = repo;
		this.cli = clie;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializarComponentes();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA REGISTRAR ACTIVIDAD");
		//Para que no pueda aumenatr el tamaño de la ventana
		setResizable(false);
		
		getContentPane().setLayout(null);
		
	}

	/*****METODOS*****/
	public void inicializarComponentes() {
		
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		inicCompActividades();
		inicCompCycling();
		inicCompSwimming();
		inicComRun();	
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\fondo-login-web.jpg"));
		lblTitulo.setBounds(0, 0, 498, 48);
		
		contentPane.add(lblTitulo);
		
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\vecteezy_abstract-geometric-background-illustration-in-flat-style_.jpg"));
		lblFondo.setBounds(0, 0, 498, 350);
		getContentPane().add(lblFondo);
	
	}
	
	public void inicComRun() {
		CadenciaRunning = new JLabel("Cadencia");
		CadenciaRunning.setBounds(277, 175, 86, 13);
		contentPane.add(CadenciaRunning);
		
		CadenciaRunning2 = new JLabel("Pasos por min");
		CadenciaRunning2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		CadenciaRunning2.setBounds(277, 185, 86, 13);
		contentPane.add(CadenciaRunning2);
		
		txtCadenciaRunning = new JTextField();
		txtCadenciaRunning.setBackground(new Color(192, 192, 192));
		txtCadenciaRunning.setColumns(10);
		txtCadenciaRunning.setBounds(363, 175, 96, 19);
		contentPane.add(txtCadenciaRunning);
		
		textNumTotPas = new JTextField();
		textNumTotPas.setColumns(10);
		textNumTotPas.setBounds(363, 150, 96, 19);
		contentPane.add(textNumTotPas);
		
		txtElevacion = new JTextField();
		txtElevacion.setColumns(10);
		txtElevacion.setBounds(362, 133, 96, 19);
		contentPane.add(txtElevacion);
		
		textRitmo = new JTextField();
		textRitmo.setBounds(363, 110, 96, 19);
		contentPane.add(textRitmo);
		textRitmo.setColumns(10);
		
		lblNumTotPas = new JLabel("Nº total pasos");
		lblNumTotPas.setBounds(277, 150, 86, 13);
		contentPane.add(lblNumTotPas);
		
		lblElevacion = new JLabel("Elevacion");
		lblElevacion.setBounds(277, 132, 75, 13);
		contentPane.add(lblElevacion);
		
		lblRitmo = new JLabel("Ritmo(hh/mm)");
		lblRitmo.setBounds(277, 110, 69, 13);
		contentPane.add(lblRitmo);
		taparRunning();
	}
	
	public void inicCompCycling() {
	
		txtCadenciaCycling = new JTextField();
		txtCadenciaCycling.setBounds(384, 66, 96, 19);
		contentPane.add(txtCadenciaCycling);
		txtCadenciaCycling.setColumns(10);
		
		lblCadencia = new JLabel("Cadencia");
		lblCadencia.setBounds(318, 69, 64, 13);
		contentPane.add(lblCadencia);
		
		lblCadenciaCycling2 = new JLabel("Pedaladas por min");
		lblCadenciaCycling2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCadenciaCycling2.setBounds(295, 78, 85, 13);
		contentPane.add(lblCadenciaCycling2);
		taparCycling();
		
	}
	public void inicCompSwimming() {
		
		lbTipoNatacion = new JLabel("Tipo de Natacion");
		lbTipoNatacion.setBounds(277, 125, 96, 13);
		contentPane.add(lbTipoNatacion);
		lbTipoNatacion.setVisible(false);
		
		
		spinnerTipoNatacion = new JSpinner();
		spinnerTipoNatacion.setModel(new SpinnerListModel(new String[] {"Piscina", "Mar"}));
		spinnerTipoNatacion.setBounds(384, 123, 75, 20);
		contentPane.add(spinnerTipoNatacion);
		spinnerTipoNatacion.setVisible(false);
		
		lblNumLargos = new JLabel("Nº de Largos");
		lblNumLargos.setBounds(288, 92, 75, 13);
		contentPane.add(lblNumLargos);
		lblNumLargos.setVisible(false);
		
		txtNumLargos = new JTextField();
		txtNumLargos.setBounds(384, 95, 96, 19);
		contentPane.add(txtNumLargos);
		txtNumLargos.setColumns(10);
		txtNumLargos.setVisible(false);
	}
	public void inicCompActividades() {
		
		JLabel lblTitutlo = new JLabel("REGISTRAR MOTO");
		lblTitutlo.setFont(new Font("Impact", Font.PLAIN, 20));
		lblTitutlo.setBounds(178, 15, 135, 25);
		contentPane.add(lblTitutlo);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(264, 258, 85, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		
		JLabel lblFcMax = new JLabel("FcMax");
		lblFcMax.setBounds(72, 184, 58, 13);
		contentPane.add(lblFcMax);
		
		lblFcMin = new JLabel("Matricula");
		lblFcMin.setBounds(30, 163, 45, 13);
		contentPane.add(lblFcMin);
		
		txtFcMax = new JTextField();
		txtFcMax.setColumns(10);
		txtFcMax.setBounds(135, 183, 96, 19);
		contentPane.add(txtFcMax);
		
		txtFcMin = new JTextField();
		txtFcMin.setColumns(10);
		txtFcMin.setBounds(135, 160, 96, 19);
		contentPane.add(txtFcMin);
		
		lblFormato = new JLabel("(yyyy-mm-ddThh:mm:ss)");
		lblFormato.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblFormato.setBounds(10, 105, 120, 13);
		contentPane.add(lblFormato);
		
		
		txtDuracion = new JTextField();
		txtDuracion.setBackground(new Color(192, 192, 192));
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(135, 230, 96, 19);
		contentPane.add(txtDuracion);
		
		txtKcalCons = new JTextField();
		txtKcalCons.setBackground(new Color(192, 192, 192));
		txtKcalCons.setColumns(10);
		txtKcalCons.setBounds(135, 208, 96, 19);
		contentPane.add(txtKcalCons);
		
		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(135, 135, 96, 19);
		contentPane.add(txtDistancia);
		
		txtFechIni = new JTextField();
		txtFechIni.setBounds(135, 89, 96, 19);
		contentPane.add(txtFechIni);
		txtFechIni.setColumns(10);
		
		btnActividad = new JButton("");
		btnActividad.setBackground(new Color(255, 255, 255));
		btnActividad.setIcon(new ImageIcon("C:\\Users\\Gaspar\\Desktop\\fotos poo\\fondo-login-web.jpg"));
		btnActividad.setBounds(253, 66, 22, 21);
		contentPane.add(btnActividad);
		btnActividad.addActionListener(this);
		JLabel lblTipoAct = new JLabel("Marca");
		lblTipoAct.setBounds(61, 69, 64, 13);
		contentPane.add(lblTipoAct);
		
		btnListo = new JButton("LISTO");
		btnListo.setBounds(169, 258, 85, 21);
		contentPane.add(btnListo);
		btnListo.addActionListener(this);
		
		
		spinerTipoActiv = new JSpinner();
		spinerTipoActiv.setModel(new SpinnerListModel(new String[] {"Suzuki", "Ducati", "Ktm", "Kawasaki", "Honda", "Aprilia", "Derbi", "Rieju", "Piaggio", "GasGas", "Husqwarna", "Yamaha"}));
		spinerTipoActiv.setBounds(135, 66, 108, 20);
		getContentPane().add(spinerTipoActiv);
		
		JLabel lblKcal = new JLabel("kcal Consnumidas");
		lblKcal.setBounds(10, 210, 115, 13);
		contentPane.add(lblKcal);
		
		JLabel lblFechIni = new JLabel("Fecha Registro");
		lblFechIni.setBounds(40, 92, 75, 13);
		contentPane.add(lblFechIni);
		
		JLabel lblDistancia = new JLabel("kmAlRegistrarse");
		lblDistancia.setForeground(new Color(64, 0, 64));
		lblDistancia.setBackground(new Color(255, 255, 255));
		lblDistancia.setBounds(20, 138, 105, 13);
		contentPane.add(lblDistancia);
		
		JLabel lblDuracion = new JLabel("Duracion en min");
		lblDuracion.setBounds(20, 230, 105, 13);
		contentPane.add(lblDuracion);

	}
	/**
	 * Metodo que destapa los componentes de swimming
	 */
	public void destaparSwimming() {
		
		lbTipoNatacion.setVisible(true);
		spinnerTipoNatacion.setVisible(true);
		lblNumLargos.setVisible(true);
		txtNumLargos.setVisible(true);
	}

	/**
	 * Metodo que tapa los componentes de swimming
	 */
	
	public void taparSwimming() {
		
		lbTipoNatacion.setVisible(false);
		spinnerTipoNatacion.setVisible(false);
		lblNumLargos.setVisible(false);
		txtNumLargos.setVisible(false);	
	}

	/**
	 * Metodo que tapa los componentes de cycling
	 */
	
	public void taparCycling() {
		this.lblCadencia.setVisible(false);
		this.txtCadenciaCycling.setVisible(false);
		this.lblCadenciaCycling2.setVisible(false);
	}

	/**
	 * Metodo que destapa los componentes de cycling
	 */
	
	public void destaparCycling() {
		this.lblCadencia.setVisible(true);
		this.txtCadenciaCycling.setVisible(true);
		this.lblCadenciaCycling2.setVisible(true);
	}
	/**
	 * Metodo que tapa los componentes de ruunning
	 */
	
	public void taparRunning() {
		txtCadenciaRunning.setVisible(false);
		txtElevacion.setVisible(false);
		textNumTotPas.setVisible(false);
		textRitmo.setVisible(false);
		lblNumTotPas.setVisible(false);
		lblElevacion.setVisible(false);
		lblRitmo.setVisible(false);
		CadenciaRunning.setVisible(false);
		CadenciaRunning2.setVisible(false);
	}
	

	/**
	 * Metodo que destapa los componentes de running
	 */
	
	public void destaparRunning() {
		txtCadenciaRunning.setVisible(true);
		txtElevacion.setVisible(true);
		textNumTotPas.setVisible(true);
		textRitmo.setVisible(true);
		lblNumTotPas.setVisible(true);
		lblElevacion.setVisible(true);
		lblRitmo.setVisible(true);
		CadenciaRunning.setVisible(true);
		CadenciaRunning2.setVisible(true);
	}
	/**
	 * Metodo que comprueba que el formato introducido es el correcto, y calcula el tiempo de duracion de la actividad
	 * @return true si es correcto el formato y false si no y saltara excepcion
	 */
	public boolean comprobarFecha() {
		
		boolean isCorrect = false;
		
		try {
			//el formato debe ser 2011-12-03T10:15:30 //yyyy-mm-ddThh:mm:ss
			DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
			
			LocalDateTime tiempo2 = LocalDateTime.parse(this.txtFechIni.getText(),formato);
			LocalDateTime tiempo3 = LocalDateTime.parse(this.txtFechFin.getText(),formato);
			isCorrect=true;
			
		} catch (DateTimeException e) {
			System.out.println("salta excepcion");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return isCorrect;
	}
	
	/**
	 * Metodo que imprime en los cuadrados de texto las kcal consumidas y la duracion
	 */
	public void mostrarCalculos() {
		Long duraMin = this.act.getDuracion().toMinutes();
		this.txtDuracion.setText(duraMin.toString());
		this.txtKcalCons.setText(Double.toString(this.act.setKcalConsumidas(this.cli.getSex(), this.cli.getEdad(), this.cli.getPeso())));
	}

	/**
	 * Metodo que se encarga de destapar o tapar los txt flied de los datos de cycling runninc o swimming, dependiendo del valor que tenga el 
	 * jspinner en el momento en el que se pulsa el boton azuls
	 */
	public void showQuest() {
		if (this.spinerTipoActiv. getModel().getValue().toString().equalsIgnoreCase("Cycling")) {
			taparSwimming();
			taparRunning();
			destaparCycling();
		}
		if (this.spinerTipoActiv.getModel().getValue().toString().equalsIgnoreCase("Running")) {
			taparCycling();
			taparSwimming();
			destaparRunning();
		}
		if (this.spinerTipoActiv.getModel().getValue().toString().equalsIgnoreCase("Swimming")) {
			taparCycling();
			taparRunning();
			destaparSwimming();
		}
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//al pulsar el boton de salir
		if(btnSalir==e.getSource()) {
			this.setVisible(false);
		}
		
		//Al pulsar el boton de actividad
		if (btnActividad==e.getSource()) {
			showQuest();
		}
		
		//Al pulsar el boton de Listo
		if (btnListo==e.getSource()) {
		
			if (comprobarFecha()==true) {
				crearActividad();
				
			}
		}
	}
	/**
	 * Metodo que devuelve un bool, dependiendo de si el spinner esta en mar o piscina, true si es piscina false si es mar
	 * @param bol
	 * @return
	 */
	public boolean marOpiscina(boolean bol) {
		
		if (this.spinnerTipoNatacion.getModel().getValue().toString().equalsIgnoreCase("Mar")) {
			bol=false;
		}
		if (this.spinnerTipoNatacion.getModel().getValue().toString().equalsIgnoreCase("Piscina")) {
			bol = true;
		}	
		return bol;
	}

	/**
	 * Metodo que se encarga de crear la actividad con los datos necesarios i de anyadirla al array de actividades i de guardar los datos en el txt
	 */
	public void crearActividad() {
		
		//ciclismo
		if (this.spinerTipoActiv.getModel().getValue().toString().equalsIgnoreCase("Cycling")) {
			
			Actividad acti = new cycling();
			
			
			
			this.act = new Cycling(LocalDateTime.parse(this.txtFechIni.getText()),LocalDateTime.parse(this.txtFechFin.getText()),Double.parseDouble(this.txtDistancia.getText()),Integer.parseInt(this.txtFcMax.getText()),Integer.parseInt(this.txtFcMin.getText()),Double.parseDouble(this.txtCadenciaCycling.getText()));	
		}
		//running
		if (this.spinerTipoActiv.getModel().getValue().toString().equalsIgnoreCase("Running")) {
				
			LocalTime ritmo = null;
			try {				
				
				DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_TIME;
				ritmo = LocalTime.parse(this.textRitmo.getText(),formato);
			
			} catch (DateTimeException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			this.act = new Running(LocalDateTime.parse(this.txtFechIni.getText()),LocalDateTime.parse(this.txtFechFin.getText()),Double.parseDouble(this.txtDistancia.getText()),Integer.parseInt(this.txtFcMax.getText()),Integer.parseInt(this.txtFcMin.getText()),Integer.parseInt(this.textNumTotPas.getText()),Integer.parseInt(this.txtElevacion.getText()),ritmo);	
		}
		//swimming
		if (this.spinerTipoActiv.getModel().getValue().toString().equalsIgnoreCase("Swimming")) {
			
			boolean bol = false;
			bol = marOpiscina(bol);
			this.act = new Swimming(LocalDateTime.parse(this.txtFechIni.getText()),LocalDateTime.parse(this.txtFechFin.getText()),Double.parseDouble(this.txtDistancia.getText()),Integer.parseInt(this.txtFcMax.getText()),Integer.parseInt(this.txtFcMin.getText()),Integer.parseInt(this.txtNumLargos.getText()),bol);
		}
	
		mostrarCalculos();

		/**
		 * Metodo que destapa los componentes de swimming
		 */
		this.repo.getJugadorArray(this.repo.devolverIndiceJugador(this.cli.getAlias())).getArrayActividadesRealizadas().add(act);
		Persistencia.persistArray(this.repo.devolverArray());
	}
}