package model;

public class Pais {
	private String nombre;
	private long habitantes;
	private String bandera; //URL
	
	public Pais() {}
	
	public Pais(String nombre, long habitantes, String bandera) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.bandera = bandera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	
}
