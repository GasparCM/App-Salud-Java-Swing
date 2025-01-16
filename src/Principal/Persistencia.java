package Principal;
package Principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia {

	/**
	 * Metodo que devuelve el arrayList donde estan los datos guardados.
	 * @return
	 */
	public static ArrayList<Cliente> getArray() {
	
		ArrayList<Cliente> clientes = null;
		  try{
	            FileInputStream readData = new FileInputStream("C:\\Users\\Gaspar\\eclipse-workspace\\Practica2POO\\memoriaApp.txt");
	            ObjectInputStream readStream = new ObjectInputStream(readData);

	            clientes = (ArrayList<Cliente>) readStream.readObject();
	            readStream.close();

	            System.out.println(clientes.toString());
	        }catch (IOException | ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
		 if (clientes!=null) {
			return clientes; 
		 }
		else {
			System.out.println("arraylist nuevo");
			return new ArrayList<Cliente>();
		}
		  
	}
	/**
	 * Metodo que usamos para guardar el arrayList en el archivo txt
	 * @param array
	 */
	public static void persistArray(ArrayList<Cliente> array) {
		
		  //write to file
        try{
            FileOutputStream writeData = new FileOutputStream("memoriaApp.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(array);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("peta al persist");
        }
	}

}
