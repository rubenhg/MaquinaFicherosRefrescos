package accesoDatos;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.corba.se.pept.transport.Connection;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;

public class AccesoBBDD implements Datos {

	private Connection conexion;

	private String bd, login, url, pwd;

	public AccesoBBDD() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			bd = "maquinarefrescos";
			login = "root";
			url = "jdbc:mysql://LocalHost/" + bd;
			pwd = "root";
			try {
				conexion = (Connection) DriverManager.getConnection(url, login, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Conexion establecida");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("No tengo el driver cargado");
		}

	}

	//@Override
//	public HashMap<Integer, Deposito> obtenerDepositos() {
//		HashMap<String, String> hdep = new HashMap<String, String>();
//		try {
//			Statement stmt;
//			if (conexion != null) {
//				stmt = conexion.createStatement();
//				ResultSet rset = stmt.executeQuery(
//						);
//				while (rset.next()) {
//					hdep.put("usuario", "" + rset.getString("Usuario"));
//					hdep.put("password", rset.getString("Password"));
//					hdep.put("email", rset.getString("email"));
//					hdep.put("nombre", "" + rset.getString("Nombre"));
//					hdep.put("apellidos", rset.getString("Apellidos"));
//					hdep.put("tipoUsuario", rset.getString("TipoUsuario"));
//				}
//
//				stmt.close();
//				rset.close();
//			} else {
//				System.out.println("conexion Nula");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return hdep;
//
//	}

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

	@Override
	public HashMap<Integer, Deposito> obtenerDepositos() {
		// TODO Auto-generated method stub
		return null;
	}

}
