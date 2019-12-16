package main;
import java.util.Scanner;

public class Notas {

	public static void main(String[] args) {
		
		float [] notas = new float[5];
		
		getNotas(notas);
		
		System.out.println("Aprobados: " + getAprobados(notas));
		System.out.println("Suspensos: " + getSuspensos(notas));
		System.out.println("Media: " + getMedia(notas));
		getOrden(notas);
		listarNotas(notas);
		
		//Num aprobados, num aprobado, lista de notas: de menor a mayor
		
	}
	
	private static void getNotas(float[]notas) {
		int numNotas = 5;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce las " + numNotas + " notas a evaluar: ");
		float nota;
		int i = 0;
		while(i < numNotas) {
			nota = sc.nextInt();
			if(notaValida(nota)) {
				notas[i] = nota;
				i++;
			}
			else System.out.println("Nota incorrecta, entre 0 y 10");
		}
		
		sc.close();
	}
	
	private static boolean notaValida(float nota) {
		return nota >= 0 && nota <= 10;
	}
	
	
	private static float getAprobados(float[] notas) {
		float aprobados = 0;
		for(float nota:notas)
			if(nota >= 5)
				aprobados++;
		return aprobados;
			
	}
	private static float getSuspensos(float[] notas) {
		float suspensos = 0;
		for(float nota:notas)
			if(nota < 5)
				suspensos++;
		return suspensos;
			
	}
	private static float getMedia(float[] notas) {
		float media = 0;
		for(float nota:notas)
			media += nota;
		return media/5;
			
	}
	
	private static void listarNotas(float[] notas) {
		for(float nota:notas)
			System.out.print(" " +nota );
	}
		
	//METODO BURBUJA
	private static void getOrden(float[] notas) {
		float aux;
		for(int i = 0; i < 5; i++) {
			for(int k = i+1; k < notas.length;k++)
				if(notas[k] < notas[i]) { //intercambio
					aux = notas[i];
					notas[i] = notas[k];
					notas[k] = aux;
				}
		}			
		
	}
}
