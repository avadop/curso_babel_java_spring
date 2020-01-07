package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Reserva;

@Repository("reservasDao")
public class ReservasDaoImpl implements ReservasDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void generarReserva(Reserva reserva) {
		this.em.persist(reserva);
	}

	@Override
	public List<Reserva> getReservas() {
		TypedQuery<Reserva> tQuery = this.em.createNamedQuery("Reserva.findAll", Reserva.class);
		return tQuery.getResultList();
	}

}
