package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String nuevoContacto(@RequestParam("email") String email) {
		this.agenda.deleteContacto(email);
		return "inicio";
	}
}
