package ejercicio04;

public class Contador {
	private int n = 0;
	private String auxNombre = "";

	public synchronized void incrementar() {
		while (auxNombre.equalsIgnoreCase(Thread.currentThread().getName())) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		auxNombre = Thread.currentThread().getName();
		System.out.print(auxNombre + " - " + n++ + ", ");
		notifyAll();
	}
}