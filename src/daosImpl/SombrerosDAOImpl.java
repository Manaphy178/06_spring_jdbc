package daosImpl;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import daos.SombrerosDAO;
import modelo.Sombrero;

/**
 * DAO= estandar en java, Data Access Object Un DAO es el elemento desde el que
 * se haecn operaciones tipo CRUD del tipo de dato indicado
 * 
 * SombrerosDAO = registrarSombrero,obtenerSombrero,etc...
 * 
 * PedidosDAO = registrarPedido, etc...
 * 
 * clase Sombrero: indicara que tiene un libro: titulo, desc etc...
 */
public class SombrerosDAOImpl implements SombrerosDAO {

	private DataSource ds;
	private SimpleJdbcInsert simpleInsert;

//necesario para que por el xml de spring le demos
//	el datasource configurado en el mismo archivo
	public void setDs(DataSource ds) {
		this.ds = ds;
		this.simpleInsert = new SimpleJdbcInsert(ds);
		this.simpleInsert.withTableName("tabla_sombreros");
	}

	public List<Sombrero> obtenerSombrero() {

		List<Sombrero> sombreros = new ArrayList<Sombrero>();
		System.out.println("por hacer");

		return sombreros;
	}


	@Override
	public void registrarSombrero(Sombrero s) {

		HashMap<String, Object> valores = new HashMap<String, Object>();
//		hay que indicar el nombre de la columna en base de datos
//		y el valor correspondiente a insertar
		valores.put("nombre", s.getNombre());
		valores.put("description", s.getDesc());
		valores.put("precio", s.getPrecio());
		this.simpleInsert.execute(valores);
	}// end registrar libro

	@Override
	public void borrarSombrero(int id) {

	}

	@Override
	public void editarSombrero(Sombrero s) {
		// TODO Auto-generated method stub

	}
}
