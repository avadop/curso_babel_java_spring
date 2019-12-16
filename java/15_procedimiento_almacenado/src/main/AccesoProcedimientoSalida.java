package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AccesoProcedimientoSalida {

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
		//EJEMPLO NO EXISTENTE
		String instr_llamada_proced = "{call librostemaSalida(?,?)}";
		
		try(Connection cn=DriverManager.getConnection(url,user,pwd);
				CallableStatement prod = cn.prepareCall(instr_llamada_proced);) {
			prod.setInt(1,1); //Numero de la columna de argumentos ?
			/*si hubiera parámetros de salida, se deben registrar
			 * Se pone el indice de que aprametro es, mas el tipo */
			prod.registerOutParameter(2, Types.INTEGER);			
			ResultSet rs = prod.executeQuery();
			
			//Obtenemos el valor del parametro de salida
			int resultado = prod.getInt(2);
			while(rs.next())
				System.out.println(rs.getString("titulo") + " " + resultado);
			rs.close();
		} catch(SQLException ex) { 
			ex.printStackTrace(); 
		}

	}

}
