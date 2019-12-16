package service;

import java.util.Collection;
import java.util.HashMap;

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
	public Contacto[] mostrarContactos() {
		return this.agenda.values().toArray(new Contacto[0]);
	}
	
	
	//esto solo para mostrarlo interesa mas lo de arriba
	public String toString() {
		String mostrar ="";
		Collection<Contacto> contactos = this.agenda.values();
		for(Contacto cont: contactos) {
			mostrar+=cont.toString()+"\n";
		}		
		return mostrar;
	}
}
