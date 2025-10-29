package ejercicio13;

public class Productor extends Thread {
	private String tipo;
	private int cantidad;
	private Tuberia tuberia;

	public Productor(String tipo, int cantidad, Tuberia tuberia) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.tuberia = tuberia;
	}

	public void run() {
		for (int i = 0; i < cantidad; i++) {
			tuberia.pasar(tipo);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
