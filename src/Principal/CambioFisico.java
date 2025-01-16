package Principal;
import java.io.Serializable;
import java.time.LocalDate;


public class CambioFisico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4789137335443526578L;
	/*****ATRIBUTOS*****/
	
	private Double imc,pesoActual;
	private LocalDate fechaActual;

	/*****CONSTRUCTORES*****/
	
	public CambioFisico(Double peso,LocalDate fecha,Double imc) {
		this.fechaActual=fecha;
		this.pesoActual=peso;
		this.imc=imc;
	}
	/*****METODOS*****/
	
	public String stringPdf() {
		String pdf = "peso: "+this.pesoActual.toString()+"\n"+"Imc: "+this.imc+"\n"+"Fecha: "+this.fechaActual.toString();
		
		return pdf;
	}
	
	
	public void imprimirInfor() {
	
		System.out.println("Fecha: "+this.fechaActual);

		System.out.println("Peso: "+this.pesoActual);

		System.out.println("IMC: "+this.imc);
		
		
		
		
	}
}
