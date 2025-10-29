package ejercicio10;

public class Hilo implements Runnable {
	Thread t;
	private Tuberia tuberia;
	private String nombre;

	public Hilo(String nombre, Tuberia tuberia) {
		this.nombre = nombre;
		this.tuberia = tuberia;
		t = new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			tuberia.comer(nombre);
		}
	}
}
