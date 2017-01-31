package accesoDatos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logicaRefrescos.Deposito;
import logicaRefrescos.Dispensador;
import accesoDatos.HibernateUtil;

public class AccesoHibernate implements Datos{
	
		HashMap<Integer,Deposito> depositos;
		
		HashMap<String,Dispensador> dispensadores;
	
	public AccesoHibernate() {
		//necesito hacer los news de depositos y dispensadores
		depositos = new HashMap<Integer,Deposito>();
		
		dispensadores = new HashMap<String,Dispensador>();
	}
	
	
	@Override
	public HashMap<Integer, Deposito> obtenerDepositos() {
		
		System.out.println("Inicio Consulta");
		
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
        Query q= session.createQuery("select * from monedas");
        
        List results = q.list();
        
        Iterator deposito = results.iterator();
        
        while (deposito.hasNext()){
            Deposito depo = (Deposito) deposito.next();
            
            depositos.put(depo.getValor(), depo);
            
            System.out.println (depo.toString());
        }
        
        session.close();
        
		return depositos;
	}

	@Override
	public HashMap<String, Dispensador> obtenerDispensadores() {
		
		System.out.println("Inicio Consulta");
		
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
        Query q= session.createQuery("select * from productos");
        
        List results = q.list();
        
        Iterator dispensador = results.iterator();
        
        for (int i = 0;dispensador.hasNext(); i++){
        	
            Dispensador dispens = (Dispensador) dispensador.next();
            
            dispensadores.put(dispens.getClave(), dispens);
            
            System.out.println (dispens.toString());
        }
        session.close();
        
		return dispensadores;
	}

	@Override
	public boolean guardarDepositos(HashMap<Integer, Deposito> depositos) {
		
		try {
			for (int info : depositos.keySet()) {
				
				Deposito dep = depositos.get(info);
				
				SessionFactory sf3 = new Configuration().configure().buildSessionFactory();
				
				Session session2 = sf3.openSession();
				
				session2.getTransaction().begin();
				
				Query query2 = session2.createQuery("update monedas set nombre = :name, inicial = :cantidad where valor = :val");
				
				query2.setParameter("name", dep.getNombreMoneda());
				
				query2.setParameter("val", dep.getValor());
				
				query2.setParameter("cantidad", dep.getCantidad());
				
				int result = query2.executeUpdate();
				
				session2.getTransaction().commit();
			}
			return true;
			
		} catch (Exception e) {
			
			System.out.println("ERRROOORRRR");
			
			System.exit(-1);
			
			return false;
		}
	}

	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		try {
			for (String claves : dispensadores.keySet()) {
				
				Dispensador disp = dispensadores.get(claves);
				
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				
				Session session = sf.openSession();
				
				session.getTransaction().begin();
				
				Query query = session.createQuery("update productos set nombre = :name, NumLatas = :cantidad, Precio = :precioo where idProductos = :id");
				
				query.setParameter("id", disp.getId());
				
				query.setParameter("name", disp.getNombreProducto());
				
				query.setParameter("cantidad", disp.getCantidad());
				
				query.setParameter("precioo", disp.getPrecio());
				
				int result = query.executeUpdate();
				
				session.getTransaction().commit();
			}
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Errorrr");
			
			System.exit(-1);
			
			return false;
		}
	}
}
