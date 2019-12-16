package model;

//ESTO SERIA UN JAVA BEAN
public class Pedido {
	private String nombre;
	private int unidades;
	private double precioUnidad;
	
	public Pedido(String nombre, int unidades, double precioUnidad) {
		this.nombre = nombre;
		this.unidades = unidades;
		this.precioUnidad = precioUnidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
}
