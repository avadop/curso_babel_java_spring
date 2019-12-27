package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;


@RestController
public class SaludoController {
	
	@GetMapping(value="saludar", produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo() {
		return "Bienvenido a mi servicio";
	}
	
	/*Nombre es el nombre de la variable que le vamos a pasar*/
	@GetMapping(value="saludar/{nombre}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo(@PathVariable("nombre") String n) {
		return "Helloooo mi friend " + n;
	}
	
	@GetMapping(value="saludar", produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona enviarPersona() {
		return new Persona("Andrea", "Avenida de america", 673028359);
	}
	
	@PostMapping(value="saludar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaPersona(@RequestBody Persona persona){
		System.out.println("Se a�ade la persona " + persona.getNombre());
	}
	
}
