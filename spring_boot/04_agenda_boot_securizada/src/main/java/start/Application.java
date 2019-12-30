package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/*Agregamos todos los paquetes que tienen clases que necesitamos que spring instancie
 * 
 * Hay que anyadir el propio paquete de start porque al poner la anotacion elimina
 * la configuracion por defecto y ya toca ponerlo para todo*/
@ComponentScan (basePackages = {"controller", "service", "dao", "start"})

/*Indicamos donde se encuentran las entidades que vamos a usar*/
@EntityScan(basePackages = {"model"})

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
