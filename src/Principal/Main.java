package Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Ventanas.PantallaPrincipal;

//TODO FALTA QUE FUNCIONE LA PERSISTENCIA
//TODO FALTA QU EN REGISTRAR ACTIVIDAD LAS KCAL SOLO TENGAN 2 O 3 DECIMALES


public class Main {
	
	private static ArrayList<Cliente>arrayClientes;
	
	public static void main(String[] args) throws Exception {
		
		Repositorio repo = null;
		try {
			
			arrayClientes=Persistencia.getArray();
		
			repo = new Repositorio(arrayClientes);	
			
			PantallaPrincipal pantallaMenu = new PantallaPrincipal(repo);
			
			pantallaMenu.setVisible(true);
					
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		
	}
			
}
