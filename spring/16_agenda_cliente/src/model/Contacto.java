package model;


public class Contacto {

	private int idContacto;
	
	private int edad;
	
	private String email;
	
	private String nombre;

	//Este constructor es obligatorio
	public Contacto() {
	}

	public Contacto(int idContacto, int edad, String email, String nombre) {
		super();
		this.idContacto = idContacto;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}

	public int getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}