package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AgendaDao;
import model.Contacto;

@Service("AgendaService")
public class AgendaServiceImpl implements AgendaService{
	@Autowired
	AgendaDao agenda;
	
	@Override
	public boolean addContacto(Contacto contacto) {
		return this.agenda.addContacto(contacto);
	}

	@Override
	public Contacto buscarContacto(String email) {
		return this.agenda.buscarContacto(email);
	}

	@Override
	public void deleteContacto(String email) {
		this.agenda.deleteContacto(email);
	}
	
	@Override
	public void deleteContacto(int id) {
		this.agenda.deleteContacto(id);
	}

	@Override
	public List<Contacto> mostrarContactos() {
		return this.agenda.mostrarContactos();
	}

	@Override
	public Contacto buscarContacto(int id) {
		return this.agenda.buscarContacto(id);
	}

	@Override
	public void modificarContacto(Contacto contacto) {
		this.agenda.modificarContacto(contacto);
	}

}
