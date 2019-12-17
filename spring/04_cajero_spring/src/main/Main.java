package main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Movimiento;
import service.CajeroService;


public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		cuenta();
		sc.close();
	}
	private static void cuenta() {
		@SuppressWarnings("resource")
		BeanFactory factory = new ClassPathXmlApplicationContext("springConfig.xml");
		CajeroService cajero =  factory.getBean(CajeroService.class); 
		int numCuenta;
		
		do{
			System.out.print("Introduce tu numero de cuenta (0 para salir): ");
			numCuenta = Integer.parseInt(sc.nextLine());
			if(cajero.buscarCuenta(numCuenta) != null)
				menu(numCuenta, cajero);
			else if(numCuenta == 0)
				System.out.println("\nHasta la vista!");
			else System.out.println("\nNumero de cuenta incorrecto, no existe \n");
		}while(numCuenta != 0);
	}
	private static void menu(int numCuenta,CajeroService cajero) {
		int op;
		do {
			System.out.println("\nMenu");
			System.out.println("1. Realizar ingreso");
			System.out.println("2. Realizar extraccion");
			System.out.println("3. Saldo y movimientos");
			System.out.println("0. Salir");
			System.out.print("Opcion elegida: ");
			op = Integer.parseInt(sc.nextLine());
			if(op == 0) //Podemos usar un switch
				return;
			else if(op == 1)
				realizarIngreso(numCuenta, cajero);
			else if(op == 2)
				realizarExtraccion(numCuenta, cajero);
			else if(op == 3)
				mostrarMovimientos(numCuenta, cajero);
			else System.out.println("\nOpcion erronea, elige otra vez\n");
			
		}while(op!=0);
	}
	private static void realizarIngreso(int numCuenta, CajeroService cajero) {
		System.out.print("\nIntroduce la cantidad que deseas ingresar: ");
		double cantidad = Double.parseDouble(sc.nextLine());
		if(cantidad > 0) {
			cajero.ingresar(numCuenta, cantidad);
			System.out.println("\nDinero total en la cuenta: " + cajero.getSaldo(numCuenta));
		}
		else System.out.println("Por favor, introduzca una cantidad positiva");
	}
	private static void realizarExtraccion(int numCuenta, CajeroService cajero) {
		System.out.print("\nIntroduce la cantidad que deseas extraer: ");
		double cantidad = Double.parseDouble(sc.nextLine());
		if(cantidad < 0)
			System.out.println("\nPor favor, introduzca una cantidad positiva");
		else {
			if(cajero.extraccion(numCuenta, cantidad))
				System.out.println("\nDinero total en la cuenta: " + cajero.getSaldo(numCuenta));
			else System.out.println("\n** No tienes suficiente dinero en tu cuenta **");
		}
	}
	private static void mostrarMovimientos(int numCuenta, CajeroService cajero) {
		System.out.println("\nSaldo total en la cuenta: " + cajero.getSaldo(numCuenta));
		List<Movimiento> movimientos = cajero.getAllMovimientos(numCuenta);
		if(movimientos.size() > 0) {
			System.out.println("\nMovimientos:");
			movimientos.stream().forEach(s -> System.out.println(s));
		}
		else System.out.println("\nNo hay movimientos");
	}
	

}
