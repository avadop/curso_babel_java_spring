package main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Contacto;
import service.AgendaService;

public class Main {
	static Scanner sc = new Scanner(System.in);
	/*Esto NO se puede resolver así, porque Spring no se ha iniciado.
	 * En la clase main tenemos que iniciar spring nosotros*/ 
	/*@Autowired
	static AgendaService agenda;*/
	
	public static void main(String[] args) {
		menu();
		System.out.println("\nHasta la Vista!!");
		sc.close();
	}
	private static void menu() {
		@SuppressWarnings("resource")
		BeanFactory factory = new ClassPathXmlApplicationContext("springConfig.xml");
		AgendaService agenda =  factory.getBean(AgendaService.class); 
		int op;
		do {
			System.out.println("Menu");
			System.out.println("1. Agregar contacto");
			System.out.println("2. Buscar contacto");
			System.out.println("3. Borrar contacto");
			System.out.println("4. Mostrar todos");
			System.out.println("0. Salir");
			System.out.print("Opcion elegida: ");
			op = Integer.parseInt(sc.nextLine());
			if(op == 0) //Podemos usar un switch
				return;
			else if(op == 1)
				agregarContacto(agenda);
			else if(op == 2)
				buscarContacto(agenda);
			else if(op == 3)
				borrarContacto(agenda);
			else if(op == 4)
				mostrarTodos(agenda);
			else System.out.println("\nOpcion erronea, elige otra vez\n");
		}while(op!=0);
		
	}
	private static void agregarContacto(AgendaService agenda){
		System.out.print("\nIntroduce el nombre del nuevo contacto: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce el email del nuevo contacto: ");
		String email = sc.nextLine();
		System.out.print("Introduce la edad del nuevo contacto: ");
		int edad = Integer.parseInt(sc.nextLine());
		if(agenda.addContacto(new Contacto(nombre, email, edad)))
			System.out.println("\nContacto agregado\n");
		else System.out.println("Contacto ya existe");
	}
	private static void buscarContacto(AgendaService agenda){
		System.out.print("\nIntroduce el email del contacto que deseas buscar: ");
		String email = sc.nextLine();
		Contacto contacto = agenda.buscarContacto(email);
		if(contacto != null)
			System.out.println(contacto.toString() + "\n");
		else System.out.println("Contacto no existe\n");
	}
	private static void borrarContacto(AgendaService agenda){
		System.out.print("\nIntroduce el email del contacto que deseas eliminar: ");
		String email = sc.nextLine();
		agenda.deleteContacto(email);
		System.out.println("Contacto eliminado\n");
	}
	private static void mostrarTodos(AgendaService agenda){
		List<Contacto> contactos = agenda.mostrarContactos();
		System.out.println();
		contactos.stream().forEach(s->System.out.println(s.toString() + "\n"));
	}

}
