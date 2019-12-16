package service;

import model.Contacto;

public interface AgendaService {

	boolean addContacto(Contacto contacto);

	Contacto buscarContacto(String email);

	boolean deleteContacto(String key);

	Contacto[] mostrarContactos();

}