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
	public boolean deleteContacto(String email) {
		return this.agenda.deleteContacto(email);
	}

	@Override
	public List<Contacto> mostrarContactos() {
		return this.agenda.mostrarContactos();
	}

}
