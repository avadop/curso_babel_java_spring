package service;

import java.util.List;

import model.Contacto;

//Simplemente llama al dao, nos la podemos saltar
public interface AgendaService {
	boolean addContacto(Contacto contacto);

	Contacto buscarContacto(String email);

	Contacto buscarContacto(int id);

	void deleteContacto(String email);
	
	void deleteContacto(int id);

	List<Contacto> mostrarContactos();
	
	void modificarContacto(Contacto contacto);
}
