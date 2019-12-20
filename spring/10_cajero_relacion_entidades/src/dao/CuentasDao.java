package dao;

import java.util.Date;
import java.util.List;

import model.Cuenta;

public interface CuentasDao {
	Cuenta getCuenta(int numCuenta); //para saber si existe o no
	void updateCuenta(Cuenta cuenta); //actualizar en bbdd
	/*Devuelve todas las cuentas que hayan realizado movimientos entre esas dos fechas*/
	List<Cuenta> obtenerCuentas(Date f1, Date f2);
}
