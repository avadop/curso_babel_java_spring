package main;
import java.util.Scanner;

public class Sumatorio {
	
	//SOLUCIÓN PROFE
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int a = sc.nextInt();
		System.out.println("Introduce otro numero");
		int b = sc.nextInt();
		int menor = buscarMenor(a,b);
		int mayor = buscarMayor(a,b);
		System.out.println("Suma de pares "+ sumaPares(menor,mayor));
		sc.close();
	}
	
	private static int buscarMenor(int a, int b) {
		return a > b ? b:a;
	}
	
	private static int buscarMayor(int a, int b) {
		return a > b ? a:b;
	}
	
	private static int sumaPares(int menor, int mayor) {
		int suma = 0; 
		for(int i = menor; i <= mayor; i++) {
			if(i%2 == 0) {
				suma+=i;
			}
		}
		return suma;
	}
}
