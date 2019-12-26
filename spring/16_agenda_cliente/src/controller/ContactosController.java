package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.AgendaService;

@Controller
public class ContactosController {
	@Autowired
	AgendaService agenda;

	/*Usamos un request mapping para recibir http:post o get, sin importarnos,
	 * como hacemos el forward en deleteContactoId hecho con Post, en el return
	 * envía una peticion post, y si este verContactos no es un post también no funciona, 
	 * para evitarnos el problema lo dejamos como requestMapping.
	 * Si usamos luego la version de get, también funcionará.
	 * Request Mapping da igual si le llega post o get.*/
	@RequestMapping(value="verContactos")
	public String getAllContactos(HttpServletRequest request) {
		request.setAttribute("getAllContactos", this.agenda.mostrarContactos());
		return "contactos";
	}
	
	//No necesitamos HttpServletRequest porque no devolvemos nada
	@PostMapping(value="addContacto")
	public String nuevoContacto(@RequestParam("nombre") String nombre,
			@RequestParam("email") String email, @RequestParam("edad") int edad) {
		this.agenda.addContacto(new Contacto(0,edad,email,nombre));
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
	@PostMapping(value="deleteContactoId")
	public String eliminarContacto(@RequestParam("id") int id) {
		this.agenda.deleteContacto(id);
		return "forward:verContactos";
	}
}
