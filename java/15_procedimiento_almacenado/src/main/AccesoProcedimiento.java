package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AccesoProcedimiento {

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/libros"; 
		String user="root";
		String pwd="root";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//Acceso al procedimiento almacenad
		String instr_llamada_proced = "{call librostema(?)}";
		
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				CallableStatement prod = cn.prepareCall(instr_llamada_proced);) {
			prod.setInt(1,1); //Numero de la columna de argumentos ?
			/*si hubiera parámetros de salida, se deben registrar
			 * Se pone el indice de que aprametro es, mas el tipo */
			//prod.registerOutParameter(2, Types...); ex: Types.VARCHAR
			ResultSet rs = prod.executeQuery();
			while(rs.next())
				System.out.println(rs.getString("titulo"));
			rs.close();
		} catch(SQLException ex) { 
			ex.printStackTrace(); 
		}

	}

}
