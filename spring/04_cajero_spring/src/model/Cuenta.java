package model;

public class Cuenta {
	private int numCuenta;
	private double saldo;
	private String tipo;
	public Cuenta(int numCuenta, double saldo, String tipo) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
