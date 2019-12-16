package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Contacto;

public class AgendaServiceImpl implements AgendaService{
	private HashMap<String,Contacto> agenda = new HashMap<>();
	
	@Override
	public boolean addContacto(Contacto contacto) {
		if(!this.agenda.containsKey(contacto.getEmail())) {
			this.agenda.put(contacto.getEmail(), contacto);
			return true;
		}
		return false;
	}
	
	@Override
	public Contacto buscarContacto(String email) {
		return this.agenda.get(email);
	}
	
	@Override
	public boolean deleteContacto(String key) {
		if(this.agenda.containsKey(key)) {
			this.agenda.remove(key);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Contacto> mostrarContactos() {
		return Arrays.asList(this.agenda.values().toArray(new Contacto[0]));
	}
}
