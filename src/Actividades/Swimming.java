package Actividades;
import java.time.LocalDateTime;

public class Swimming extends Actividad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6015975692844570520L;
	/*****ATRIBUTOS*****/
	
	//si el booleano es false quiere decir que es en el mar y si es verdadero es en la piscina
	private boolean typeNatacion=false;
	private int numLargos;
	
	

	/*****CONSTRUCTOR*****/
	
	public Swimming(LocalDateTime fechainic, LocalDateTime fechafin, Double distancia, int fcMax, int fcMin,int numLargo,boolean type) {
		super(fechainic, fechafin, distancia, fcMax, fcMin);
		this.numLargos=numLargo;
		this.typeNatacion=type;
	}
	
}
