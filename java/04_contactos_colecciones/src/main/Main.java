package main;

import java.util.Scanner;

import model.Contacto;
import service.Agenda;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		menu();
		System.out.println("\nHasta la Vista!!");
		sc.close();
	}
	
	private static void menu() {
		Agenda agenda = new Agenda();
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
	private static void agregarContacto(Agenda agenda){
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
	private static void buscarContacto(Agenda agenda){
		System.out.print("\nIntroduce el email del contacto que deseas buscar: ");
		String email = sc.nextLine();
		Contacto contacto = agenda.buscarContacto(email);
		if(contacto != null)
			System.out.println(contacto.toString() + "\n");
		else System.out.println("Contacto no existe\n");
	}
	private static void borrarContacto(Agenda agenda){
		System.out.print("\nIntroduce el email del contacto que deseas eliminar: ");
		String email = sc.nextLine();
		if(agenda.deleteContacto(email))
			System.out.println("Contacto eliminado\n");
		else System.out.println("Contacto no existe\n");
	}
	private static void mostrarTodos(Agenda agenda){
		Contacto[] contactos = agenda.mostrarContactos();
		System.out.println();
		for(Contacto con: contactos) {
			System.out.println(con.toString()+"\n");
		}
	}

}
