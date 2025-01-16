package Principal;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


import Actividades.Actividad;

public class Cliente implements Serializable {

	/*****ATRIBUTOS*****/
	private static final long serialVersionUID = 1L;
	
	protected String alias,password,nombre,apellido1,apellido2;
	protected int edad;
	protected boolean sexo;
	protected Double peso;
	protected Double altura;
	protected Double imc;
	protected LocalDate fechaInic,fechaFini,fechaNacimiento;
	protected ArrayList<Actividad>arrayActividadesRealizadas;
	protected ArrayList<CambioFisico>arrayCambioFisico;
	protected FactorActividad factorActividad;
	
	
	/*****CONSTRUCTORES * @throws Exception *****/
	
	public Cliente(String alias,String pass,LocalDate fecha,boolean sexo,Double peso,Double altura,FactorActividad factor) throws Exception {
		
		comprobarPassword(pass);
		this.alias=alias;
		this.password=pass;
		this.fechaNacimiento=fecha;
		this.setSexo(sexo);
		this.setPeso(peso);
		this.altura=altura;
		this.factorActividad=factor;
		this.arrayCambioFisico = new ArrayList<>();
		this.arrayActividadesRealizadas=new ArrayList<>();
		calcularImc();
		
	}
	/*****METODOS*****/
	Cliente Mario =  new Cliente(alias, password, fechaFini, sexo, peso, altura, factorActividad);
	/**
	 * Metodo que devuelve el sexo de la persona, si es true es hombre si es false es mujer
	 * @return
	 */
	public boolean getSex() {
		return this.sexo;
	}
	
	/**
	 * Metodo que calcula el Imc del cliente en cuestion, se usa en el constructor
	 */
	public void calcularImc() {
		
		this.imc=this.getPeso()/(this.altura*this.altura);
		
	}
	
	/**
	 * Metoo que cambia el peso del cliente por el que le pasemos a esta funcion y añade al array cambio fisico 
	 * un objeto cambi fisico con el peso que le pasamos la fecha en la que se guarda y el imc
	 * @param peso
	 */
	public void cambiarPeso(Double peso) {
		this.setPeso(peso);
		calcularImc();
		CambioFisico cambio = new CambioFisico(this.getPeso(), LocalDate.now(), this.imc);		
		this.arrayCambioFisico.add(cambio);
	}
	
	/**
	 * Metodo para comprobar que la password introducida tiene tamaño 6 o mas, y que contiene almenos un numero y letra
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	public boolean comprobarPassword(String s) throws Exception {
		boolean isCorrect = false,containsNumber=false,containsChar=false;
		String numeros = "1234567890";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		//si la longitud es mayor o 6
		
			if (s.length()>=6) {		
				
				for (int i = 0; i < s.length() && (containsNumber==false || containsChar==false); i++) {
					if (letras.contains(s.substring(i,i+1))) {
						containsChar=true;
					}	
					
					if (numeros.contains(s.substring(i,i+1))) {
						containsNumber=true;
					}
	
				}
				if (containsChar==false) {
					throw new Exception("La contraseña debe contener almenos una letra");
				}
				if (containsNumber==false) {
					throw new Exception("La contraseña debe contener almenos un numero");	
				}	
			}
			else {
				throw new Exception("La contraseña debe tener longitud 6 minimo");
			}
			
		return isCorrect;
	}
	
	/**
	 * Metodo que comprueba si la contraseña es correcta, true si es correcta y false si no
	 * @param s
	 * @return
	 */
	public boolean correctPassword(String s) {
		
		boolean isCorrect = false;
		if (this.password.equals(s)) {
			isCorrect=true;
		}
		
		return isCorrect; 	
	}
	/**
	 * Metodo que cambia la contraseña anterior por la que le pasamos como parametro
	 * @param pass
	 */
	public void cambiarPassword(String pass) {
		
		this.password=pass;
	
	}
	/**
	 * Metodo to strinf, que devuelve un string con todos los datos del cliente concatenados y separados
	 * @return
	 */
	public String stringPdf() {
		
		String sex;

		if (isSexo()==true) {
			sex="Hombre";
		}
		else {
			sex = "Mujer";
		}
		
		
		String datosCliente = "nombre:"+this.nombre+"\n"+"alias:"+this.alias+"\n"+"apellido 1:"+this.apellido1+"\n"+"apellido2:"+this.apellido2+"\n"+
				"contraseña:"+this.password+"\n"+"edad:"+this.edad+"\n"+"sexo: "+sex+"\n"+"fechaNacimineto:"+this.fechaNacimiento+"\n"+"peso:"+this.getPeso()+
				"\n"+"altura:"+this.altura+"\n"+"imc:"+this.imc+"\n"+"factor Actividad:"+""+this.factorActividad.toString();

		return datosCliente;
	}
	
	/**
	 * Metodo que imprime por pantalla la informacion del cliente en cuestion
	 */
	
	public void imprimirInformacion() {
	
		String sex;
		System.out.println("nombre:"+this.nombre);
		System.out.println("alias:"+this.alias);
		System.out.println("apellido 1:"+this.apellido1);
		System.out.println("apellido2:"+this.apellido2);
		System.out.println("contraseña:"+this.password);
		System.out.println("fechaNacimineto:"+this.fechaNacimiento);	
		System.out.println("edad:"+this.edad);
		if (isSexo()==true) {
			sex="Hombre";
			System.out.println("sexo: "+sex);	
		}
		else {
			sex = "Mujer";
			System.out.println("sexo: "+sex);
		}
		System.out.println("peso:"+this.getPeso());
		System.out.println("altura:"+this.altura);
		System.out.println("imc:"+this.imc);
		System.out.println("factor Actividad:"+this.factorActividad.toString());
		
		imprimCambioFisic();
		imprimirActis();
		
	}
	/**
	 * Metodo que imprime por pantalla el array de Actividades del cliente en cuestion
	 */
	
	public void imprimirActis() {
		
		System.out.println("*****ACTIVIDADES REALIZADAS*****");
	
		for (int i = 0; i < arrayActividadesRealizadas.size(); i++) {
			
			System.out.println("\nactividad "+(i+1)+": \n");
			
			arrayActividadesRealizadas.get(i).imprimirInfo();
		}
		
		
	}
	/**
	 * Metodo que imprime por pantalla el array de cambioFisico del cliente en cuestion
	 */
	public void imprimCambioFisic() {
		
		System.out.println("*****CAMBIO FISICO*****");
		for (int i = 0; i < arrayCambioFisico.size() ; i++) {
			System.out.println("\nCambioFisico: "+(i+1)+": \n");
			arrayCambioFisico.get(i).imprimirInfor();
		}
		
		
		/*****GETTERS Y SETTERS*****/
		
	}
	public String getApellido1() {
		return apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setApellido1(String text) {
		this.apellido1=text;
	}


	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public ArrayList<Actividad> getArrayActividadesRealizadas() {
		return arrayActividadesRealizadas;
	}

	public void setArrayActividadesRealizadas(ArrayList<Actividad> arrayActividadesRealizadas) {
		this.arrayActividadesRealizadas = arrayActividadesRealizadas;
	}

	public ArrayList<CambioFisico> getArrayCambioFisico() {
		return arrayCambioFisico;
	}

	public void setArrayCambioFisico(ArrayList<CambioFisico> arrayCambioFisico) {
		this.arrayCambioFisico = arrayCambioFisico;
	}
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getImc() {
		return imc;
	}
	
	public void setImc(double imc) {
		this.imc = imc;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}	
}
