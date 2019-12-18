package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
