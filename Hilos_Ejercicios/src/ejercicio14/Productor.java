package ejercicio14;

public class Productor extends Thread {
	private Tuberia tuberia;
	private int cantidad;

	public Productor(Tuberia tuberia, int cantidad) {
		this.tuberia = tuberia;
		this.cantidad = cantidad;
	}

	public void run() {
		for (int i = 0; i < cantidad; i++) {
			tuberia.pasar(this.getName());
			try {
				Thread.sleep((long) (1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
