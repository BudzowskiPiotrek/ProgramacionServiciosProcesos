package ejercicio08;

public class Tuberia {
	private boolean terminoRey = false;

	public synchronized void saluda(String tipo, String saludo) {
		if (tipo.equalsIgnoreCase("Rey")) {
			terminoRey = true;
		}
		while (!terminoRey) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(saludo);
		notifyAll();
	}
}
