package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import Principal.Cliente;
import Principal.FactorActividad;
import Principal.Persistencia;
import Principal.Repositorio;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class VentanaAppSalud extends JFrame implements ActionListener {

	/*****ATRIBUTOS*****/

	private JPanel contentPane;
	private JButton btnAnyadirActividad,btnAnyadirPeso,btnCambiarContrasea,btnSalir,btnGenInfo, btnConvPrime,btnGenPdf;
	private JLabel lblFondo;
	private Repositorio repo;
	private Cliente cli;
	private JLabel lblNombreUsuario;
	private JLabel lblPeso;
	private JLabel lblAltura,lblEdad;


	/*****CONSTRUCORES*****/
	
	public VentanaAppSalud(Repositorio repo,Cliente cli) {
		
		this.cli = cli;
		this.repo=repo;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\logo.png"));
		//que hace esto?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializarComponentes();
		//Para que se ejecute el panel en el centro de la pantalla
		setLocationRelativeTo(null);
		//Añadimos un titulo a la ventana
		setTitle("VENTANA APP");
		setResizable(false);
		
	}
	
	/*****METODOS*****/
	
	public void inicializarComponentes() {
		
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblEdad = new JLabel("");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(10, 70, 92, 15);
		contentPane.add(lblEdad);
		
		lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setBounds(10, 10, 92, 15);
		contentPane.add(lblNombreUsuario);
		
		lblAltura = new JLabel("");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(10, 50, 92, 15);
		contentPane.add(lblAltura);
		
		//para el cuadradito de arriba izq
		lblPeso = new JLabel("");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(10, 30, 92, 15);
		contentPane.add(lblPeso);
		
		btnAnyadirPeso = new JButton("CONSULTAR CLIENT");
		btnAnyadirPeso.setBounds(150, 80, 155, 21);
		contentPane.add(btnAnyadirPeso);
		btnAnyadirPeso.addActionListener(this);
		
		
		btnGenInfo = new JButton("BUSCAR PER MATRIUCLA");
		btnGenInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGenInfo.setForeground(new Color(0, 0, 0));
		btnGenInfo.setBackground(new Color(255, 255, 255));
		btnGenInfo.setBounds(150, 172, 155, 21);
		contentPane.add(btnGenInfo);
		btnGenInfo.addActionListener(this);
		
		JLabel lblFondoUsuario = new JLabel("");
		lblFondoUsuario.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\vecteezy_abstract-geometric-background-illustration-in-flat-style_.jpg"));
		lblFondoUsuario.setBounds(10, 10, 92, 83);
		contentPane.add(lblFondoUsuario);
		
		btnAnyadirActividad = new JButton("AÑADIR CLIENT");
		btnAnyadirActividad.setBounds(150, 50, 155, 21);
		contentPane.add(btnAnyadirActividad);
		btnAnyadirActividad.addActionListener(this);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(150, 234, 155, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		btnGenPdf = new JButton("LISTA");
		btnGenPdf.setForeground(Color.BLACK);
		btnGenPdf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGenPdf.setBackground(new Color(255, 255, 255));
		btnGenPdf.setBounds(150, 203, 155, 21);
		contentPane.add(btnGenPdf);
		btnGenPdf.addActionListener(this);
		//
		
		
		btnConvPrime = new JButton("CREAR FACTURA ");
		btnConvPrime.setBounds(150, 141, 155, 21);
		contentPane.add(btnConvPrime);
		btnConvPrime.addActionListener(this);
		
		btnCambiarContrasea = new JButton("AÑADIR MOTO SIN CLIENTE");
		btnCambiarContrasea.setForeground(new Color(0, 0, 0));
		btnCambiarContrasea.setBackground(new Color(255, 255, 255));
		btnCambiarContrasea.setBounds(150, 110, 155, 21);
		contentPane.add(btnCambiarContrasea);
		btnCambiarContrasea.addActionListener(this);
		btnCambiarContrasea.addActionListener(this);
		
		lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(255, 255, 255));
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\fotosPoo\\8172f32cc85e02fe8c7cec5f5fd176fb.jpg"));
		lblFondo.setBounds(-25, -102, 693, 415);
		contentPane.add(lblFondo);
		
		mostrarDatosUsuario();
		
		
	}
	
	/**
	 * Metodo que pinta en el cuadro de arriba izquierda la informacion del usuario en cuestion
	 */
	public void mostrarDatosUsuario() {
		lblNombreUsuario.setText(this.cli.getAlias());
		lblAltura.setText(this.cli.getAltura().toString()+" m");
		lblPeso.setText(this.cli.getPeso().toString()+" kg");
		lblEdad.setText(this.cli.getEdad()+" anyos");
	}
	/**
	 * Metodo que devuelve un double para hacer los calculos de kcal necesarias 
	 * @param fac
	 * @return
	 */
	public double calcFactAct(FactorActividad fac) {
		double valorFactAct = 0;
		
		switch (fac) {
		case sedentaria :
			valorFactAct=1.2;
			break;

		case actividadLigera :
			valorFactAct=1.375;
			break;
		case actividadModerada :
			valorFactAct=1.55;
			break;
		
		case actividadIntensa :
			valorFactAct=1.725;
			break;
					
		case actividadExtrema :
			valorFactAct=1.9;
			break;
		default:
			break;
		}
		return valorFactAct;
		
	}
	/**
	 * Metodo que calcula y devuelve las kcalNecesarias dependiendo de ciertos parametros que se le pasan a la funcion.Se calcula segun formula aportada por desi
	 * @param peso
	 * @param estatura
	 * @param edad
	 * @param sexo
	 * @param fac
	 * @return
	 */
	public Double kcalNecesarias(Double peso,Double estatura,int edad,boolean sexo,FactorActividad fac ) {
		
		Double valFacAct = calcFactAct(fac);
		Double kcalNecesarias;
		
		//si es hombre
		if (sexo==true) {
			kcalNecesarias=((66+(13.7*peso))+(5*estatura)-(6.8*edad))*valFacAct;
		}
		//si es mujer
		else {
			kcalNecesarias=((655+(9.6*peso))+(1.8*estatura)-(4.7*edad))*valFacAct;
			
		}
		
		return kcalNecesarias;
	}

	/**
	 * Metodo que crea un archivo pdf y guarda en el los datos del jugador en cuestion
	 */
	public void pdf() {
		Document doc = new Document();  
		String infoCliente,infoActiv,infoCambio;
		PdfWriter writer;
		try  
		{  
			
			//generamos el pdf, le ponemos la direccion donde g0uardarlo y el nombre que va a tener
			writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\pdfPOO\\playerData.pdf"));  
			System.out.println("PDF created.");  
			
			//opens the PDF  
			doc.open();  
			  
			doc.add(new Paragraph("*****INFORMACION CLIENTE*****\n"));
			//le asignamos a infoCliente un string con toda la informacion del cliente concatenada y separada con \n
			infoCliente = this.cli.stringPdf();
			//anyadimos un paragrafo con infoCliente
			doc.add(new Paragraph(infoCliente));   
			
			//
			doc.add(new Paragraph("\n*****ACTIVIDADES REALIZADAS*****"));
			for (int i = 0; i < this.cli.getArrayActividadesRealizadas().size(); i++) {
			
				doc.add(new Paragraph("\nactividad "+(i+1)+": \n"));
				infoActiv=this.cli.getArrayActividadesRealizadas().get(i).stringPdf();
				doc.add(new Paragraph(infoActiv));
			}

			//
			doc.add(new Paragraph("\n*****CAMBIO FISICO*****"));
			for (int i = 0; i < this.cli.getArrayCambioFisico().size(); i++) {
				doc.add(new Paragraph("\nCambio Fisico "+(i+1)+": \n"));
				infoCambio = this.cli.getArrayCambioFisico().get(i).stringPdf();
				doc.add(new Paragraph(infoCambio));
			}
			//
			
			//close the PDF file
			doc.close();  
			//closes the writer  
			writer.close();  
		}   
		catch (DocumentException e)  
		{  
			System.out.println(e.getMessage());  
			
		}   
		catch (FileNotFoundException e)  
		{  
			System.out.println(e.getMessage());  
			
		}  
	}  
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//si pulsa el boton de añadir actividad
		if (btnAnyadirActividad==e.getSource()) {
			VentanaRegistrarActividad vent = new VentanaRegistrarActividad(this.repo,this.cli);
			vent.setVisible(true);
		}
		//si pulsa el boton de añadirpeso
		if (btnAnyadirPeso==e.getSource()) {
			Double peso = Double.parseDouble(JOptionPane.showInputDialog("Introduce tu peso actual"));
			this.repo.getJugadorArray(this.repo.devolverIndiceJugador(this.cli.getAlias())).cambiarPeso(peso);
			mostrarDatosUsuario();
			Persistencia.persistArray(this.repo.devolverArray());
			
		}
		//si pulsa el boton de cambiar contraseña
		if (btnCambiarContrasea==e.getSource()) {
			CambiarContrasenya ven = new CambiarContrasenya(this.repo, this.cli);
			ven.setVisible(true);
		}
		//si pulsa el boton de salir
		if (btnSalir==e.getSource()) {
			this.setVisible(false);
			
		}
		//si pulsa boton generar info
		if (btnGenInfo==e.getSource()) {
			this.cli.imprimirInformacion();
				
		}
		//si pulsa boton convertir a prime
		if (btnConvPrime==e.getSource()) {
			CambiarPrime cambio = new CambiarPrime(this.repo, this.cli);
			cambio.setVisible(true);
		}
		//si pulsa generar pdf
		if (btnGenPdf==e.getSource()) {
			pdf();
		}
	}
}
