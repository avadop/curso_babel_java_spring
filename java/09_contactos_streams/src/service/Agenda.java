package service;

import java.util.Collection;
import java.util.HashMap;

import model.Contacto;

public class Agenda {
	private HashMap<String,Contacto> agenda = new HashMap<>();
	
	public boolean addContacto(Contacto contacto) {
		if(!this.agenda.containsKey(contacto.getEmail())) {
			this.agenda.put(contacto.getEmail(), contacto);
			return true;
		}
		return false;
	}
	
	public Contacto buscarContacto(String email) {
		return this.agenda.get(email);
	}
	
	public boolean deleteContacto(String key) {
		if(this.agenda.containsKey(key)) {
			this.agenda.remove(key);
			return true;
		}
		return false;
	}
	
	public Contacto[] mostrarContactos() {
		return this.agenda.values().toArray(new Contacto[0]);
	}
	
	public Contacto[] mostrarOrdenados() {
		return this.agenda.values().stream().sorted((a,b) -> a.getEdad() - b.getEdad()).toArray(t -> new Contacto[t]);
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
