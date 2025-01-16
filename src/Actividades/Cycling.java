package Actividades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cycling extends Actividad {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2799361310947291996L;
	/*****ATRIBUTOS*****/
	
	private Double cadencia;
	
	/*****CONSTRUCTORES*****/
	
	public Cycling(LocalDateTime fechainic, LocalDateTime fechafin, Double distancia, int fcMax, int fcMin,Double cadencia) {
		super(fechainic, fechafin, distancia, fcMax, fcMin);
		this.cadencia=cadencia;
		
	}

	/*****METODOS*****/

	

}
