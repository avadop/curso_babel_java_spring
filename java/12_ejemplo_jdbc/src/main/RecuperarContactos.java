package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecuperarContactos {

	//Cuando se ejecute esta clase salga un listado con todos los contactos en la bbdd
	public static void main(String[] args) {
				String driver="com.mysql.jdbc.Driver"; 
				//jdbc:mysql://servidor:puerto/basedatos
				String url="jdbc:mysql://localhost:3306/agenda2"; 
				String user="root";
				String pwd="root";
				
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return;
				}
				String sql="select * from contactos";
				
				try(Connection cn=DriverManager.getConnection(url,user,pwd);
						Statement st = cn.createStatement(); //st y rs tambien se cierran
						ResultSet rs = st.executeQuery(sql);) {
					
					while(rs.next()) {
						System.out.println(rs.getString("nombre"));
					}
				} catch(SQLException ex) { 
					ex.printStackTrace(); 
				}

	}

}
