package service;

import java.util.List;

import model.Contacto;

public interface AgendaService {

	boolean addContacto(Contacto contacto);

	Contacto buscarContacto(String email);

	void deleteContacto(String key);

	List<Contacto> mostrarContactos();

}