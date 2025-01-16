package Principal;
import java.io.Serializable;
import java.time.LocalDate;

public class ClienteVip extends Cliente implements Serializable  {


	/*****ATRIBUTOs*****/
	
	private static final long serialVersionUID = 1L;

	
	
	/*****CONSTRUCTORES*****/
	
	/**
	 * Construcor de copia que a su vez aprovechamos y le pasamos la contraseña nueva para que se compruebe que cumple los requisitos vip
	 * @param cli
	 * @param newPass
	 * @throws Exception
	 */
	public ClienteVip(Cliente cli,String newPass) throws Exception {
	
	super(cli.alias, newPass, cli.fechaFini, cli.isSexo(),cli.getPeso(), cli.altura, cli.factorActividad);
	
	comprobarPassword(newPass);
	this.password=newPass;
	this.fechaNacimiento=cli.fechaNacimiento;
	this.imc=cli.imc;
	this.fechaInic=cli.fechaInic;
	this.fechaFini=cli.fechaFini;
	
	}

	/*****METODOS*****/
	
	/**
	 * Metodo para comprobar que la password introducida tiene tamaño 8 o mas, y que contiene almenos un numero, letra y caracter
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	public boolean comprobarPassword(String s) throws Exception {
		boolean isCorrect = false,containsNumber=false,containsChar=false,containsCaract=false;
		String numeros = "1234567890";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		String caracteres = ",.;:-_ºª!|@;·#$~%$/()=?'¿¡*";
		//si la longitud es mayor o 6
		
			if (s.length()>=8) {		
				
				for (int i = 0; i < s.length() && (containsNumber==false || containsChar==false||containsCaract==false); i++) {
					if (letras.contains(s.substring(i,i+1))) {
						containsChar=true;
					}	
					
					if (numeros.contains(s.substring(i,i+1))) {
						containsNumber=true;
					}
					if (caracteres.contains(s.substring(i, i+1))) {
						containsCaract=true;
					}
	
				}
				if (containsChar==false) {
					throw new Exception("La contraseña debe contener almenos una letra");
				}
				if (containsNumber==false) {
					throw new Exception("La contraseña debe contener almenos un numero");	
				}
				if (containsCaract==false) {
					throw new Exception("La contraseña debe contener almenos un caracter (,.º...)");
				}
			}
			else {
				throw new Exception("La contraseña debe tener longitud minima 8");
			}
			
		return isCorrect;
	}
	
}
