package ejercicio05;

import java.util.Random;

public class Camello extends Thread {
	private String nombre;
	private Podio podio;

	public Camello(int numero, Podio podio) {
		this.nombre = "Camello " + numero;
		this.podio = podio;
	}

	public void run() {
		for (int i = 1; i <= 25; i++) {
			System.out.println("El " + nombre + " va por el metro " + i);
			try {
				Thread.sleep(new Random().nextInt(100));
			} catch (InterruptedException e) {
				return;
			}
		}
		podio.registrarLlegada(nombre);
	}
}
