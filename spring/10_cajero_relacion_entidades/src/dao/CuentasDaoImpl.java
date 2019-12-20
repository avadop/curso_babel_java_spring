package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	/*Devuelve todas las cuentas que hayan realizado movimientos entre esas dos fechas*/
	public List<Cuenta> obtenerCuentas(Date f1, Date f2){
		String jpql = "select c from Cuenta c join c.movimientos m where m.fecha between ?1 and ?2";
		TypedQuery<Cuenta> tQuery = this.em.createQuery(jpql,Cuenta.class);
		tQuery.setParameter(1, f1);
		tQuery.setParameter(2, f2);
		return tQuery.getResultList();
	}

}
