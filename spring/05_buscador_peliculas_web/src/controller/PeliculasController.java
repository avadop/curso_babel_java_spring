package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pelicula;

/*Es una clase que tiene que manejar string por debajo*/
@Controller
public class PeliculasController {
	/*Esto es el equivalente a conexion con la base de datos, 
	* pero como no hay capa negocio en esta parte se queda así */
	List<Pelicula> peliculas = new ArrayList<>(); 
	
	public PeliculasController() { //2 comedia, 3 dramas y 1 terror
		this.peliculas.add(new Pelicula("Pelicula 1","comedia",120));
		this.peliculas.add(new Pelicula("Pelicula 2","drama",150));
		this.peliculas.add(new Pelicula("Pelicula 3","terror",180));
		this.peliculas.add(new Pelicula("Pelicula 4","drama",105));
		this.peliculas.add(new Pelicula("Pelicula 5","comedia",150));
		this.peliculas.add(new Pelicula("Pelicula 6","drama",90));
	}
	
	/*Es el metodo que genera acciones. 
	 * Los atributos son los que necesitemos en cada caso concreto. 
	 * Para que se ejecute al darle al boton tenemos que poner una anotacion
	 * del tipo de accion que se esta realizando (get, post...)*/

	/* cuando llegue una peticion desde el cliente que sea del tipo post y
	 * y que venga con la direccion del value, que se ejecute el metodo.*/
	@PostMapping(value = "/verPeliculas")
	/* Para volcar un parametro que viene de una peticion en una variable se hace 
	 * con la siguiente anotacion en tematica: */
	public String recuperarPeliculas(@RequestParam("tematica") String tematica,HttpServletRequest request) {
		List<Pelicula> resultado = this.peliculas.stream()
				.filter(p -> p.getTematica().equals(tematica))
				.collect(Collectors.toList());
		/*guardamos la lista de peliculas en un atributo de peticion
		 * para que sea recogido por la vista y pueda generar la respuesta */
		request.setAttribute("peliculas", resultado);
		/*Devolvemos la direccion de la pagina (vista) encargada de generar la respuesta.
		 * No ponemos nada mas que eso porque el resto lo resuelve spring*/
		return "peliculas";
	}
	
	@GetMapping(value="/verPeliculas")
	public String recuperarPeliculas(HttpServletRequest request) {
		request.setAttribute("peliculas", this.peliculas);
		return "peliculas";
	}
}
