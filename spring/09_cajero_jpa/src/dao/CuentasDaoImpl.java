package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cuenta;

@Repository("cuentasDao")
public class CuentasDaoImpl implements CuentasDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Cuenta getCuenta(int numCuenta) {
		return this.em.find(Cuenta.class, numCuenta);
	}
	
	@Transactional
	@Override
	public void updateCuenta(Cuenta cuenta) {
		this.em.merge(cuenta);
	}

}
