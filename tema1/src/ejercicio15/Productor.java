package ejercicio15;

public class Productor implements Runnable {
	Thread t1;
	private Tuberia tuberia;

	public Productor(Tuberia tuberia) {
		t1 = new Thread(this);
		this.tuberia = tuberia;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			tuberia.depositar(500);
			System.out.println("Estado despues de sacar " + tuberia.getEstadoCuenta());
		}
	}

}
