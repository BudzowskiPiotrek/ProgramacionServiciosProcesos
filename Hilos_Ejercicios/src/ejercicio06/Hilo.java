package ejercicio06;

import java.util.Random;

public class Hilo extends Thread {
	Contador contador;
	private int valor;

	public Hilo(int i, Contador c) {
		this.setName("Dado nº " + i);
		this.contador = c;
	}

	@Override
	public void run() {
		valor = new Random().nextInt(6) + 1;
		System.out.println(getName() + " ha lanzado un " + valor);
		contador.resultado(valor);
	}
}