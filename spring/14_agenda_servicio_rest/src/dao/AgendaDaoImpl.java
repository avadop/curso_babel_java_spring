package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;

@Repository("agendaDao")
public class AgendaDaoImpl implements AgendaDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public boolean addContacto(Contacto contacto) {
		this.em.persist(contacto);
		return true;
	}
	
	@Override
	public Contacto buscarContacto(String email) {
		TypedQuery<Contacto> tQuery = this.em.createNamedQuery("Contacto.findByEmail", Contacto.class);
		tQuery.setParameter(1, email);
		List<Contacto> contactos = tQuery.getResultList();
		return contactos.size()>0? contactos.get(0) : null;
	}
	
	@Transactional
	@Override
	public void deleteContacto(String email) {
		Query query = this.em.createNamedQuery("Contacto.deleteByEmail");
		query.setParameter(1, email);
		query.executeUpdate();
	}
	
	@Transactional
	@Override
	public void deleteContacto(int id) {
		Contacto contacto = this.em.find(Contacto.class,id);
		if(contacto != null) 
			this.em.remove(contacto);
		
	}

	@Override
	public List<Contacto> mostrarContactos() {
		TypedQuery<Contacto> tQuery = this.em.createNamedQuery("Contacto.findAll", Contacto.class);
		return tQuery.getResultList();
	}

	@Override
	public Contacto buscarContacto(int id) {
		return this.em.find(Contacto.class, id);
	}
	
	@Transactional
	@Override
	public void modificarContacto(Contacto contacto) {
		this.em.merge(contacto);
	}

}
