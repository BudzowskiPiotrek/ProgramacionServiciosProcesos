package ejercicio02;

import java.util.Scanner;

public class App {
	
	// Crear tres hilos en el que cada uno escriba durante su ejecución el siguiente
	// mensaje, donde el color sea introducido por teclado antes de la ejecución del
	// hilo: "Hola, el mundo es de color [color]"
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedir los tres colores por teclado
		System.out.print("Introduce el primer color (ROJO, VERDE, AMARILLO): ");
		String color1 = scanner.nextLine().toUpperCase();
		System.out.print("Introduce el segundo color (ROJO, VERDE, AMARILLO): ");
		String color2 = scanner.nextLine().toUpperCase();
		System.out.print("Introduce el tercer color (ROJO, VERDE, AMARILLO): ");
		String color3 = scanner.nextLine().toUpperCase();

		Thread h1 = new Thread(new Hilo(color1));
		Thread h2 = new Thread(new Hilo(color2));
		Thread h3 = new Thread(new Hilo(color3));

		h1.start();
		h2.start();
		h3.start();
	}

}
