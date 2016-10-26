package accesoDatos;

import java.util.HashMap;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;

public  class AccesoBBDD implements Datos{
	

	@Override
	public HashMap<Integer, Deposito> obtenerDepositos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Dispensador> obtenerDispensadores() {
		// TODO Auto-generated method stub
		return null;
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
