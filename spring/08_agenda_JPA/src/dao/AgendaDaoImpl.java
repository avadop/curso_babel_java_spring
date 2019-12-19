package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
	
	/*Como es recuperar por email y no es el id, no es una operacion basica CRUD*/
	@Override
	public Contacto buscarContacto(String email) {
		//Detrás de la interrogacion hay que marcar en qué posición se va a usar luego
		//String jpql="Select c From Contacto c where c.email=?1";
		//Otra manera
		//String jpql="Select c From Contacto c where c.email= :eml";
		
		//TypedQuery<Contacto> tQuery = this.em.createQuery(jpql,Contacto.class);
		//Otra manera
		TypedQuery<Contacto> tQuery = this.em.createNamedQuery("Contacto.findByEmail", Contacto.class);
		tQuery.setParameter(1, email);
		//tQuery.setParameter("eml",email);
		try {
			return tQuery.getSingleResult();
		} /*Dos excepciones, si hay mas de uno o si no hay ninguno
		Vamos a gestionarlas de maneras diferentes*/
		catch(NoResultException ex) {
			return null;
		}catch(NonUniqueResultException ex) {
			//Devolvemos el primero de los que tienen el mismo mail
			return tQuery.getResultList().get(0);
		}
		//Otra manera
		/*List<Contacto> contactos = tQuery.getResultList();
		return contactos.size()>0? contactos.get(0) : null;*/
	}
	
	@Transactional
	@Override
	public void deleteContacto(String email) {
		//String jpql = "delete from Contacto c where c.email=?1";
		//Query query = this.em.createQuery(jpql);
		Query query = this.em.createNamedQuery("Contacto.deleteByEmail");
		query.setParameter(1, email);
		query.executeUpdate();
	}
	
	@Transactional
	@Override
	public void deleteContacto(int id) {
		//Contacto.class dice qué tipo de clase estas buscando
		Contacto contacto = this.em.find(Contacto.class,id);
		//Como remove necesita el objeto lo buscamos primero.
		if(contacto != null) 
			this.em.remove(contacto);
		
	}

	@Override
	public List<Contacto> mostrarContactos() {
		/*String jpql ="Select c From Contacto c";
		TypedQuery<Contacto> tQuery = this.em.createQuery(jpql,Contacto.class);*/
		//Utilizamos una namedQuery, definida en la entidad
		TypedQuery<Contacto> tQuery = this.em.createNamedQuery("Contacto.findAll", Contacto.class);
		return tQuery.getResultList();
	}

}
