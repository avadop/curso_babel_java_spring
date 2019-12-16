package dao;

import model.Cuenta;

public interface CuentasDao {
	Cuenta getCuenta(int numCuenta); //para saber si existe o no
	void updateCuenta(Cuenta cuenta); //actualizar en bbdd	
}
