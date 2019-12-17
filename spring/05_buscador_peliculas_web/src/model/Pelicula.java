package model;

public class Pelicula {
	private String titulo;
	private String tematica;
	private int duracion;
	public Pelicula(String titulo, String tematica, int duracion) {
		super();
		this.titulo = titulo;
		this.tematica = tematica;
		this.duracion = duracion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
