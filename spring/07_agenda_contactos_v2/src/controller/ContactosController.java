package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.AgendaService;

@Controller
public class ContactosController {
	@Autowired
	AgendaService agenda;
	
	@GetMapping(value="verContactos")
	public String getAllContactos(HttpServletRequest request) {
		request.setAttribute("getAllContactos", this.agenda.mostrarContactos());
		return "contactos";
	}
	
	//No necesitamos HttpServletRequest porque no devolvemos nada
	@PostMapping(value="addContacto")
	public String nuevoContacto(@RequestParam("nombre") String nombre,
			@RequestParam("email") String email, @RequestParam("edad") int edad) {
		this.agenda.addContacto(new Contacto(nombre, email,edad));
		return "inicio";
	}
	
	@PostMapping(value="deleteContacto")
	public String eliminarContacto(@RequestParam("email") String email) {
		this.agenda.deleteContacto(email);
		return "inicio";
	}
	//MODO PROFE
	/*@GetMapping(value="deleteContactoId")
	public String eliminarContacto(@RequestParam("id") int id) {
		this.agenda.deleteContacto(id);
		return "forward:verContactos";
	}*/
	//MODO LUIS
	/*Usamos un request mapping para recibir el http:post de la vista (formulario), 
	 * porque cuando hacemos el forward, como verContactos es un método GET, se envía 
	 * un POST de este método y salta error 405. De esta manera con el request mapping
	 * no importa qué le llegue que lo puede reenviar, en vez de recibir post, le llega
	 * lo que necesite.
	 * En la pagina .jsp nos cargamos el method="loquesea"*/
	@RequestMapping(value="deleteContactoId")
	public String eliminarContacto(@RequestParam("id") int id) {
		this.agenda.deleteContacto(id);
		return "forward:verContactos";
	}
}
