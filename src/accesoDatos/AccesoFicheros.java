package accesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;

public class AccesoFicheros implements Datos {
	Deposito deposito;
	Dispensador dispensador;

	@Override
	public HashMap<Integer, Deposito> obtenerDepositos() {
		HashMap<Integer, Deposito> depositosCreados = new HashMap<Integer, Deposito>();

		String fichero = "Ficheros/Monedas.txt";
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] aux = linea.split(";");
				String nombre = aux[0];
				int valor = Integer.parseInt(aux[1]);
				int inicial = Integer.parseInt(aux[2]);
				Deposito depAux = new Deposito(nombre, valor, inicial);
				depositosCreados.put(valor, depAux);

			}
			fr.close();
		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
			System.out.println("Ruta erronea de fichero");
			System.exit(-1);
		}

		return depositosCreados;
	}

	@Override
	public HashMap<String, Dispensador> obtenerDispensadores() {
		HashMap<String, Dispensador> dispensadoresCreado = new HashMap<String, Dispensador>();

		String fichero = "Ficheros/Productos.txt";
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] aux = linea.split(";");
				String clave = aux[0];
				String nombre = aux[1];
				int p = Integer.parseInt(aux[2]);
				int inicial = Integer.parseInt(aux[3]);
				Dispensador dispAux = new Dispensador(clave, nombre, p, inicial);
				dispensadoresCreado.put(clave, dispAux);

			}

			fr.close();
		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
			System.out.println("Ruta erronea de fichero");
			System.exit(-1);
			
		}
		return dispensadoresCreado;
	}

	@Override
	public boolean guardarDepositos(HashMap<Integer, Deposito> depositos) {
		try {

			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter("Ficheros/Monedas.txt"));

			for (Entry<Integer, Deposito> entrada : depositos.entrySet()) {
				Deposito depAux = entrada.getValue();
				bw.write(depAux.getNombreMoneda() + ";" + depAux.getValor() + ";" + depAux.getCantidad());
				bw.newLine();

			}
			bw.close();
			return true;
		} catch (Exception e) {
			System.exit(1);
			return false;
		}

	}

	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		try {

			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter("Ficheros/Productos.txt"));

			for (Entry<String, Dispensador> entrada : dispensadores.entrySet()) {
				Dispensador dispAux = entrada.getValue();
				bw.write(dispAux.getClave() + ";" + dispAux.getNombreProducto() + ";" + dispAux.getPrecio() + ";"
						+ dispAux.getCantidad());
				bw.newLine();

			}
			bw.close();
			return true;

		} catch (Exception e) {
			System.exit(1);
			return false;
		}

	}

}
