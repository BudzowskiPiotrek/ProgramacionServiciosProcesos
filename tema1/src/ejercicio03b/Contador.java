package ejercicio03b;

public class Contador {
	private int n = 0;

	public synchronized void contar() {
		n++;
	}

	public synchronized void imprimir() {
		System.out.println(n);
		
	}
}
