package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Item;

@Service
public class ClienteAgendaServiceImpl implements ClienteAgendaService {
	@Autowired
	RestTemplate template;
	// Se pone la direccion del id del servicio, eureka lo conecta
	String url = "http://servicio-agenda";
	
	/*Recibe del controlador los datos del nuevo contacto y tiene que 
	 * interaccionar con el otro servicio para realizar las operaciones*/
	@Override
	public void procesarContacto(Item item) {
		Item contacto = template.getForObject(url + "/buscar/"+item.getEmail(), Item.class);
		if(contacto == null) 
			template.postForLocation(url+"/addContacto", item);
		else {
			contacto.setEdad(item.getEdad());
			contacto.setNombre(item.getNombre());
			template.put(url+"/modificar", contacto);
		}
	}

	/*@Override
	public List<Item> getContactos() {
		return Arrays.asList(template.getForObject(url + "/contactos", Item[].class));
	}*/
	
	/*Queremos el cuerpo y saber el valor del encabezado*/
	@Override
	public List<Item> getContactos() {
		ResponseEntity<Item[]> contactos = template.getForEntity(url+"/contactos", Item[].class);
		//System.out.println(contactos.getHeaders());
		return Arrays.asList(contactos.getBody());
	}
}
