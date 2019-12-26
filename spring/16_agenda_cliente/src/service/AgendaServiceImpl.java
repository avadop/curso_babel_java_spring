package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Contacto;

@Service("AgendaService")
public class AgendaServiceImpl implements AgendaService{
	@Autowired
	RestTemplate template;
	String url ="http://localhost:8080/14_agenda_servicio_rest";
	@Override
	public boolean addContacto(Contacto contacto) {
		template.postForLocation(url + "/addContacto", contacto);
		return true;
	}
	@Override
	public Contacto buscarContacto(String email) {
		//No lo hacemos porque no hace falta para el ejemplo
		return null;
	}
	@Override
	public void deleteContacto(String email) {
		template.delete(url+"/eliminarEmail/" + email);
	}
	@Override
	public void deleteContacto(int id) {
		template.delete(url+"/eliminarId/" + id);
	}
	@Override
	public List<Contacto> mostrarContactos() {
		return Arrays.asList(template.getForObject(url+"/contactos", Contacto[].class));
	}

}
