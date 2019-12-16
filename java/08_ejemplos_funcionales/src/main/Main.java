package main;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(10);numeros.add(50);numeros.add(18);
		numeros.add(42);numeros.add(30);numeros.add(5);
		numeros.add(10); numeros.add(4);
		
		//Elevamos contenido al cuadrado
		numeros.replaceAll(a -> a*a);
		
		//Ordenar con lambda
		//Si la resta es positiva, es que x es mayor, es negativo si es menor
		//Devuelve negativo o positivo la funcion
		numeros.sort((x,y) -> x-y);
		//Si le damos la vuelta a la resta los ordena de mayor a menor.
		
		/*Eliminar los números menores que 25
		* Intuicion principal --> Mala practica
		* 
		* for(int i = 0; i < numeros.size();i++) {
		* 	if(numeros.get(i) < 25)
		*		numeros.remove(i);
		* } 
		* Al ir quitando segun encontramos se va redimensionando el size
		* y puede petar. Si fueramos de atrás a alante no pasaría*/
		
		/*Con interfaz funcional: Predicate
		 * Funcion de array list: removeIf(Predicate<? super E> filter )
		 * E son los elementos del array.
		 * esta funcion aplica test a cada elementos del array --> sería un if predicate
		 * Tenemos que implementar el predicate*/
		//numeros.removeIf(new Criterio());
		
		//EXPRESION LAMBDA
		numeros.removeIf(t -> t<25);
				
		//Recorremos y mostramos lo que queda
		/*for(int n : numeros)
			System.out.println(n);*/
		//Con expresiones lambda: Programación funcional
		numeros.forEach(t -> System.out.println(t));
	}
}

class Criterio implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t<25;
	}
	
}
