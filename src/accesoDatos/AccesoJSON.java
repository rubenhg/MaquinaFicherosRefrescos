package accesoDatos;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;

public class AccesoJSON implements Datos{
	
	Deposito deposito;
	Dispensador dispensador;
	@SuppressWarnings("unchecked")
	@Override
	
	public HashMap<Integer, Deposito> obtenerDepositos() {
		
			
		Gson gson = new GsonBuilder().create();
		
		String json = "http://localhost/MaquinaRefrescos/backend/Jsonbackend.php";
		
		
		HashMap<Integer, Deposito> depositosCreados = new HashMap<Integer, Deposito>();
		
		
		depositosCreados = (HashMap<Integer,Deposito>) gson.fromJson(json, depositosCreados.getClass());
		
		System.out.println(depositosCreados);
		
		
		return depositosCreados;
		

		
		
		
	}

	@Override
	public HashMap<String, Dispensador> obtenerDispensadores() {
		HashMap<String, Dispensador> dispensadoresCreado = new HashMap<String, Dispensador>();
		
		
		
		return dispensadoresCreado;
	}

	@Override
	public boolean guardarDepositos(HashMap<Integer, Deposito> depositos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
