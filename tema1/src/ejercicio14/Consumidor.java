package ejercicio14;

public class Consumidor extends Thread {
	private Tuberia tuberia;

	public Consumidor(Tuberia tuberia) {
		this.tuberia = tuberia;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			tuberia.imprimir();
		}
	}
}
