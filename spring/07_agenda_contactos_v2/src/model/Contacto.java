package model;

public class Contacto {
	private String nombre;
	private String email;
	private int edad;
	private int idContacto;
	
	public Contacto(int idContacto, String nombre, String email, int edad) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	public Contacto(String nombre, String email, int edad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String toString() {
		return "Nombre: "+this.nombre+"\nEmail: "+this.email+"\nEdad: "+this.edad;
	}
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
}
