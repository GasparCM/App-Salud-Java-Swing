package Actividades;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Actividad implements Serializable{

	private static final long serialVersionUID = 5085894480576751368L;

	/*****ATRIBUTOS*****/

	protected LocalDateTime fechaInicio,fechaFin;
	protected Double distancia,kcalConsumidas;
	protected Duration duracion;//duracion de la actividad, entre fecha ini i final
	protected int fcMax,fcMin,fcMed;//fcMed calculado como (fcMax+fMin)/a
	
	/*****CONSTRUCTORES*****/

	public Actividad(LocalDateTime fechainic, LocalDateTime fechafin,Double distancia,int fcMax,int fcMin) {

		this.fechaInicio=fechainic;
		this.fechaFin=fechafin;
		this.distancia=distancia;
		this.fcMax=fcMax;
		this.fcMin=fcMin;
		this.duracion = Duration.between(fechainic, fechafin);
		comprobarFecha(fechainic, fechafin);
	}
	
	/*****METODOS*****/

	/**
	 * Metodo que comprueba que el formato introducido es el correcto, y calcula el tiempo de duracion de la actividad
	 * @return true si es correcto el formato y false si no y saltara excepcion
	 */
	public boolean comprobarFecha(LocalDateTime fechain,LocalDateTime fechafi) {
		
		boolean isCorrect = false;
		
		try {
			//el formato debe ser 2011-12-03T10:15:30 //yyyy-mm-ddThh:mm:ss
			DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	
			String value = fechain.format(formato);
			String value2 = fechain.format(formato);
			
			this.duracion = Duration.between(fechain, fechafi);
			
			System.out.println(value+" "+value2); 
			System.out.println("la duracion es de : "+duracion.toMinutes()+" minutos");
			isCorrect=true;
			
		} catch (DateTimeException e) {
			System.out.println("salta excepcion");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return isCorrect;
	}
	/**
	 * Metodo que guarda en fcMed la media entre fcMax i fcMin
	 * @param fcMax
	 * @param fcMin
	 */
	public void calcularFcMed(Integer fcMax,Integer fcMin) {
		
		this.fcMed=(fcMax+fcMin)/2;
	}
	
	
	/**
	 * Función para devolver las Kcal consumidas, diferente según la actividad
	 */
	public Double setKcalConsumidas(boolean sexo, int edad, Double peso){
		//si es hombre
		if(sexo == true) {
			kcalConsumidas =  ( (edad*0.2017) - (peso*0.09036) + (fcMed*0.6309) - 55.0969 )      * (duracion.toMinutes())  / 4.184;
		}
		//si es mujer
		else {
			kcalConsumidas =  ( (edad*0.0074) - (peso*0.05741) + (fcMed*0.4472) - 20.4022 )      * (duracion.toMinutes()/60000)  / 4.184;
		}
		
		return kcalConsumidas;
	}
	
	/**
	 * Metodo que imprime por pantalla la informacion de la actividad
	 */
	public void imprimirInfo() {
		
		System.out.println("fecha inicio: "+this.fechaInicio);
		System.out.println("fecha final: "+this.fechaFin);
		System.out.println("duracion: "+this.duracion.toMinutes());
		System.out.println("Distancia: "+this.distancia);
		System.out.println("Fc Min: :"+this.fcMin);
		System.out.println("Fc Max:"+this.fcMax);
		System.out.println("Fc Medio:"+this.fcMed);
		System.out.println("Kcal consumidas:"+this.kcalConsumidas);
	}
	/**
	 * Metodo que devuelve un string con la informacion de la actividad
	 * @return
	 */
	public String stringPdf() {
		String infoActi="fecha inicio: "+this.fechaInicio+"\n"+"fecha final: "+this.fechaFin+
				"\n"+"duracion: "+this.duracion.toMinutes()+"\n"+
				"Distancia: "+this.distancia+"\n"+"Fc Min: :"+this.fcMin+"\n"+"Fc Max:"+this.fcMax+"\n"+"Fc Medio:"+this.fcMed+"\n"+"Kcal consumidas:"+this.kcalConsumidas;
	
		return infoActi;
	}
	
	/*****GETTER Y SETTERS*****/

	public void setDistancia1(double pp) {
		// TODO Auto-generated method stub
		this.distancia=pp;
	}
	
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	public double getDistancia() {
		return distancia;
	}
	public double getKcalConsumidas() {
		return kcalConsumidas;
	}
	
}
