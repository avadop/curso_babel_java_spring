package dao;

import java.util.List;

import model.Movimiento;

public interface MovimientosDao {
	List<Movimiento> getAllMovimientos(int idCuenta);
	void addMovimiento(Movimiento movimiento);
}
