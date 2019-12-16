package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class AgendaServiceJdbcImpl implements AgendaService {
	private static final String driver="com.mysql.jdbc.Driver"; 
	private static final  String url="jdbc:mysql://localhost:3306/agenda2"; 
	private static final  String user="root";
	private static final  String pwd="root";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public boolean addContacto(Contacto contacto) {
		boolean ok = false;
		String sql="Insert into contactos (nombre,email,edad) values('"+contacto.getNombre()+
				"','"+contacto.getEmail()+"','"+contacto.getEdad()+"')";
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				Statement st = cn.createStatement();) {
			st.execute(sql);
			ok = true;
		}
		catch(SQLException ex) { 
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public Contacto buscarContacto(String email) {
		Contacto contacto = null;
		String sql="select * from contactos where email ='" + email+"'";
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			if(rs.next()) 
				contacto = new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("edad"));
		}
		catch(SQLException ex) { 
			ex.printStackTrace(); 
		}
		return contacto;
	}

	@Override
	public void deleteContacto(String key) {
		String sql="delete from contactos where email ='" + key+"'";
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				Statement st = cn.createStatement();){
			st.execute(sql);
		}
		catch(SQLException ex) { 
			ex.printStackTrace(); 
		}
	}

	@Override
	public List<Contacto> mostrarContactos() {
		List<Contacto> contactos = new ArrayList<>();
		String sql="select * from contactos";
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while(rs.next()) 
				contactos.add(new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("edad")));
		}
		catch(SQLException ex) { 
			ex.printStackTrace(); 
		}
		return contactos;
	}

}
