package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Proyecto para comprender como darnos de alta en la bbdd,
 * no es la practica normal de trabajo con bases de datos*/
public class TestContactos {

	public static void main(String[] args) {
		//ESTA INFO SUELE ESTAR EN OTRO ARCHIVO, NO EN CODIGO
		String driver="com.mysql.jdbc.Driver"; //nombre del driver
		//jdbc:mysql://servidor:puerto/basedatos
		String url="jdbc:mysql://localhost:3306/agenda2"; //url donde esta la bbdd
		String user="root"; //usuario con permisos
		String pwd="root"; //contraseña del usuario
		
		/*//Das el nombre de la clase y ya te lo instancia
		 * Se hace asi en vez de con new porque así te abstraes de la info*/
		//No lo metemos en el otro tryCatch porque se crea necesita para el connection
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
				
		
		//establecer conexion con la BD, lo metemos en un try con recursos
		//Nos olvidamos del finally y llamada a close
		try(Connection cn=DriverManager.getConnection(url,user,pwd);) {
			
			//Definimos la instruccion SQL, le decimos que añada una nueva fila con esos datos
			String sql="Insert into contactos (nombre,email,edad) values('profe','aaa@google.es',22)";
			
			//Ejecutamos la instruccion
			Statement st = cn.createStatement();
			st.execute(sql);

			System.out.println("Contacto añadido!");
		}
		/*catch(ClassNotFoundException ex) {
			ex.printStackTrace(); //Te dice la traza de error
		}
		catch(SQLException ex) {
			ex.printStackTrace(); //Te dice la traza de error
		}*/
		catch(SQLException ex) { //multicatch
			ex.printStackTrace(); //Te dice la traza de error
		}

	}

}
