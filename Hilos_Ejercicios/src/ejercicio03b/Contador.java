package ejercicio03b;

public class Contador {
	private int n = 0;
	private int actual = 1;

	public synchronized void contar(int i) {
		while (i == actual) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		actual = i;
		n++;
		System.out.println("numero " + actual + " " + n);

		notifyAll();
	}
}
