package service;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroService {
	Cuenta buscarCuenta(int numCuenta);
	double getSaldo(int numCuenta);
	List<Movimiento> getAllMovimientos(int numCuenta);
	void ingresar(int numCuenta, double cantidad);
	boolean extraccion(int numCuenta, double cantidad);
	List<Cliente> titularesCuenta(int numeroCuenta);
}
