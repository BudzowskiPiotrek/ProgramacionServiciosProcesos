package ejercicio03;

public class Contador {
	private int numero = 0;

	public synchronized void incrementar() {
		numero++;
		System.out.println(Thread.currentThread().getName() + " ha contado: " + numero);
	}
}
