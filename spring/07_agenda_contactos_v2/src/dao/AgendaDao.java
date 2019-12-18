package dao;

import java.util.List;

import model.Contacto;

public interface AgendaDao {
	boolean addContacto(Contacto contacto);

	Contacto buscarContacto(String email);

	boolean deleteContacto(String email);
	
	boolean deleteContacto(int id);

	List<Contacto> mostrarContactos();
}
