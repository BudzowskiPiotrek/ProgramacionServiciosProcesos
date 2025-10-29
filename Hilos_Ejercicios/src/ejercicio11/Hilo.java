package ejercicio11;

public class Hilo implements Runnable {
	Thread t;
	private Tuberia tuberia;
	private String color;
	public Hilo(Tuberia tuberia, String color) {
		this.tuberia = tuberia;
		this.color = color;
		t = new Thread(this);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				tuberia.cambioSemaforo(color);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
