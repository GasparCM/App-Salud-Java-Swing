package Principal;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Repositorio implements Serializable{

	/*********ATRIBUTOS*********/
	
	private ArrayList<Cliente>arrayClientes;
	private static final long serialVersionUID = -2444004235571456921L;
	
	/*********CONSTRUCTORES
	 * @throws Exception *********/

	public Repositorio(ArrayList<Cliente>arrayCli) throws Exception {
		
		this.arrayClientes=arrayCli;
	}

	/*********METODOS*********/
	public ArrayList<Cliente> devolverArray(){
		
		return this.arrayClientes;
	}
	/**
	 * Metodo para comprobar si se repite el alias de dos jugadores en el array de jugadores, lo usare en el constructor para comprobar nadie
	 * tega el mismo alias para que no pueda fallar dsps buscando clientes
	 */
	public void seLlamaAlguienIgual() {
		for (int i = 0; i < arrayClientes.size(); i++) {
			for (int j = 1; j < arrayClientes.size(); j++) {
				if (arrayClientes.get(i).getAlias().equalsIgnoreCase(arrayClientes.get(j).getAlias())) {
					System.out.println("Existen dos personas con el mismo alias");
				}
			}		
		}
	}
	
	
	/**
	 * Metodo para añadir un jugador al arrayList de jugadores
	 * @param jugador
	 */
	public void anyadirPersona(Cliente pers) {
		
		arrayClientes.add(pers);
		Persistencia.persistArray(this.arrayClientes);
	}
	
	/**
	 * Metodo que devuelve un jugador del array dependiendo del indice que le pasemos como parametro
	 * @param i
	 * @return jugador
	 */
	public Cliente getJugadorArray(int i){
		
		return arrayClientes.get(i);
	}
	
	/**
	 * Metodo que comprueba si el string del alias que le pasamos como parametro existe ya en otra persona registrada 
	 * @param 
	 * @return si ya existe devuelve true, si no devuelve false
	 */
	public boolean seRepiteAlias(String alias) {
		
		boolean seRepite=false;
		
		for (int i = 0; i < arrayClientes.size(); i++) {
			if (arrayClientes.get(i).getAlias().equalsIgnoreCase(alias)) {
				JOptionPane.showMessageDialog(null, "El alias introducido ya existe en otro jugador, introduce otro");
				seRepite=true;
			}
		}
		return seRepite;
	}
	/**
	 * Metodo que comprueba si el string que pasamos por parametro coincide con el alias 
	 * de algun cliente del array
	 * @param alias
	 * @return
	 */
	public boolean existeEnArray(String alias) {
		
		boolean seRepite=false;
		
		for (int i = 0; i < arrayClientes.size(); i++) {
			if (arrayClientes.get(i).getAlias().equalsIgnoreCase(alias)) {
				seRepite=true;
			}
		}
		return seRepite;
	}
	
	/**
	 * Metodo que devuelve el indice del jugador que contenga el alias que le pasamos como parametro
	 * @param alias
	 * @return
	 */
	public int devolverIndiceJugador(String alias) {
		
		int i=0,j = 0;
			
		for (i = 0; i < arrayClientes.size(); i++) {
			if (arrayClientes.get(i).getAlias().equalsIgnoreCase(alias)) {
				j=i;
			}
		}
	
		return j;	
	}
	
	/**
	 * Metodo que comprueba si la constraseña que le pasamos como parametro a la funcion es correcta con el jugador del array con indice que le pasemos como parametro
	 * y devuelve true si la contraseña es correcta, y false si la contraseña no lo es
	 * @param i
	 * @param password
	 * @return
	 **/
	public boolean esContrasenaCorrecta(int i,String password) {
		
		boolean esCorrecta=false;
		
		if (arrayClientes.get(i).correctPassword(password)==true) {
			esCorrecta=true;
		}
		
		return esCorrecta;
	}
		
	/**
	 * Metodo que imprime por pantalla la informacion del arrayList
	 */
	public void imprimirRepo() {
		System.out.println("*****INFORME DE CLIENTES REGISTRADOS*****\n");
		for (int i = 0; i < arrayClientes.size(); i++) {
			System.out.println("Cliente numero "+(i+1));
			arrayClientes.get(i).imprimirInformacion();
			System.out.println("");
		}
	}
	
}
