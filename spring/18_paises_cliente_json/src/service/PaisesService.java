package service;

import java.util.List;

import org.json.simple.parser.ParseException;

import model.Pais;

public interface PaisesService {
	List<Pais> getAllPaises() throws ParseException ;
	
	Pais getPais(String nombre) throws ParseException;
}
