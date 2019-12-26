package main;

import org.springframework.web.client.RestTemplate;

import model.Contacto;

/**
 * Es una clase de prueba para probarlo desde el punto de vista 
 * del cliente, con todos los requests.*/
public class Main {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		String url ="http://localhost:8080/14_agenda_servicio_rest";
		
		//recurso que devuelve todos los contactos
		/* Un array de objetos json no se puede transformar en un List, solo en un array
		* en la clase cliente deberiamos tener una clase tambien con los mismos atributos,
		* aunque tenga distinto nomnbre. */
		Contacto[] contactos = template.getForObject(url+"/contactos", Contacto[].class);
		for(Contacto c: contactos)
			System.out.println("Nombre: "+c.getNombre());
		
		//Recurso que devuelve el contacto por id
		Contacto contacto = template.getForObject(url+"/contacto/477", Contacto.class);
		System.out.println("---------------------------------------------------------");
		System.out.println(contacto.getNombre());
		
		//Recurso que añade contactos
		/*Contacto contacto2  =new Contacto(0,100,"hola@gmail.com", "queTal");
		template.postForLocation(url+"/addContacto", contacto2);*/
		
		//Recurso actualizar contactos
		Contacto contacto3 = new Contacto(509,236, "lolili@gmail.com", "actuAndrea");
		template.put(url+"/modificar", contacto3);
		
		//Recurso que elimina por email
		template.delete(url + "/eliminarEmail/easy@gmail.com");
		
	}
}
