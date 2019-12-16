package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;

public class Main {

	public static void main(String[] args) {
		// Solicitar datos de 3 pedidos y luego nos saque precio total
		ArrayList<Pedido> lista = new ArrayList<>();
		pedirDatos(lista);
		System.out.println("El total de la facturacion es: " + getFacturacion(lista));
	}
	
	private static void pedirDatos(ArrayList<Pedido> lista) {
		Scanner sc = new Scanner(System.in);
		int numPedidos = 5;
		
		for(int i = 0; i < numPedidos;i++) {
			System.out.print("Introduce el nombre del pedido: ");
			String nombre = sc.nextLine();
			System.out.print("Introduce la cantidad del pedido: ");
			//Parseamos porque da problema si no el next line del nombre
			//Otra opción es crear distintos scanners
			int cantidad = Integer.parseInt(sc.nextLine());
			System.out.print("Introduce el precio del pedido: ");
			double precio = Double.parseDouble(sc.nextLine());			
			
			lista.add(new Pedido(nombre, cantidad, precio));
		}		
		sc.close();
	}
	
	private static double getFacturacion(ArrayList<Pedido> lista) {
		double total = 0;		
		for(Pedido pedido: lista) {
			total += pedido.getPrecioUnidad()*pedido.getUnidades();
		}		
		return total;
	}
	
	private static Pedido[] convertirArray(ArrayList<Pedido> pedidos) {
		/*Para que la función sepa de que objeto se trata le tenemos que pasar un 
		objeto de tamanyo 0 y asi ya te lo crea todo como tiene que ser*/
		return pedidos.toArray(new Pedido[0]); 
	}
}
