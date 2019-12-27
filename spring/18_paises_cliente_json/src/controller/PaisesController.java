package controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.PaisesService;

@Controller
public class PaisesController {
	@Autowired
	PaisesService service;
	
	@GetMapping(value="/")
	public String getPaises(HttpServletRequest request) throws ParseException {
		request.setAttribute("getPaises", service.getAllPaises());
		return "inicio";
	}
	
	@PostMapping(value="clickPais")
	public String getDatos(HttpServletRequest request, 
			@RequestParam("nombre") String nombre) throws ParseException {
		request.setAttribute("getPais", service.getPais(nombre));
		return "datos";
	}
}
