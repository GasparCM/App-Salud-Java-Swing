package Actividades;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Running extends Actividad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2849448187413405206L;
	/*****ATRIBUTOS*****/
	private int numPasos,elevacion;
	private long cadencia;
	private LocalTime ritmo;
	
	/*****CONSTRUCTORES*****/
	
	public Running(LocalDateTime fechainic, LocalDateTime fechafin, Double distancia, int fcMax, int fcMin,int numPasos,int elevacio,LocalTime ritmo){
		super(fechainic, fechafin, distancia, fcMax, fcMin);
		this.numPasos=numPasos;
		this.cadencia=this.duracion.toMinutes()/numPasos;
		this.elevacion=elevacio;
		this.ritmo=ritmo;
		
	}
	public void imprimirInfo() {
		
		System.out.println("fecha inicio: "+this.fechaInicio);
		System.out.println("fecha final: "+this.fechaFin);
		System.out.println("duracion: "+this.duracion.toMinutes());
		System.out.println("Distancia: "+this.distancia);
		System.out.println("Fc Min: :"+this.fcMin);
		System.out.println("Fc Max:"+this.fcMax);
		System.out.println("Fc Medio:"+this.fcMed);
		System.out.println("Numero de pasos:"+this.numPasos);
		System.out.println("Numero de elvacion:"+this.elevacion);
		System.out.println("Cadencia(pasos x mins):"+this.cadencia);
		System.out.println("Ritmo:"+this.ritmo.getMinute());
		
	}
	
}
