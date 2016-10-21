package accesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;

public class LeerFichero implements Datos {

	@Override
	public HashMap<Integer, Deposito> obtenerDepositos() {
		HashMap<Integer, Deposito> depositosCreados = new HashMap<Integer, Deposito>();

		String fichero = "Fichero.txt";
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] aux = linea.split(";");
				String nombreMoneda = aux[0];
				int valor = Integer.parseInt(aux[1]);
				int inicial = Integer.parseInt(aux[2]);
				Deposito depAux = new Deposito(nombreMoneda, valor, inicial);

			}
			fr.close();
		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
		}

		return depositosCreados;
	}

	@Override
	public HashMap<String, Dispensador> obtenerDispensadores() {
		HashMap<String, Dispensador> dispensadoresCreado = new HashMap<String, Dispensador>();
		
		String fichero = "Fichero.txt";
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null){
			String [] aux = linea.split(";");
			String clave=aux[0];
			String nombre=aux[1];
			int p = Integer.parseInt(aux[2]);
			int inicial = Integer.parseInt(aux[3]);
			
			}
			

			fr.close();
		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
		}
		return dispensadoresCreado;
	}

	@Override
	public boolean guardarDepositos(HashMap<Integer, Deposito> depositos) {
		try {
			String ruta = "fichero.txt";
	        File fichero = new File(ruta);
	        BufferedWriter bw = null;
	        if(fichero.exists()) {
	            bw = new BufferedWriter(new FileWriter(fichero));
	            bw.write("Existe fichero de texto");
	        } else {
	           System.out.println("no hay fichero");
	           bw.close();
	        }
	        
	    } catch (Exception e) {
			System.exit(1);
		}
		return false;
	}

	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		// TODO Auto-generated method stub
		return false;
	}

}
