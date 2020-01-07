package service;

import java.util.List;

import model.Item;

public interface ClienteAgendaService {

	public void procesarContacto(Item item);
	
	public List<Item> getContactos();
}
