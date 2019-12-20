package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Movimiento;

@Repository("movimientosDao")
public class MovimientosDaoImpl implements MovimientosDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movimiento> getAllMovimientos(int idCuenta) {
		TypedQuery<Movimiento> tQuery = this.em.createNamedQuery("Movimiento.findByCuenta", Movimiento.class);
		tQuery.setParameter(1, idCuenta);
		return tQuery.getResultList();
	}
	
	@Transactional
	@Override
	public void addMovimiento(Movimiento movimiento) {
		this.em.persist(movimiento);
		
	}
	
	/*Encontramos todos los movimientos que sean de una cuenta de un tipo concreto*/
	@Override
	public List<Movimiento> getMovimientosTipoCuenta(String tipoCuenta) {
		//Consulta anidada
		String jpql = "Select m from Movimiento m where m.cuenta.tipocuenta=?1";
		TypedQuery<Movimiento> tQuery = this.em.createQuery(jpql,Movimiento.class);
		tQuery.setParameter(1, tipoCuenta);
		return tQuery.getResultList();
	}
}
