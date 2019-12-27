package dao;

import java.util.List;

import model.Contacto;

public interface AgendaDao {
	boolean addContacto(Contacto contacto);

	Contacto buscarContacto(String email);
	
	Contacto buscarContacto(int id);

	void deleteContacto(String email);
	
	void deleteContacto(int id);

	List<Contacto> mostrarContactos();
	
	void modificarContacto(Contacto contacto);
	
}
