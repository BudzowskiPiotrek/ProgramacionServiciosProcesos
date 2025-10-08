package ejercicio15;

public class Consumidor implements Runnable {
	Tuberia tuberia;
	Thread t1;

	public Consumidor(Tuberia tuberia) {
		this.tuberia = tuberia;
		t1 = new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			tuberia.retirar(500);
			System.out.println("Estado despues de sacar " + tuberia.getEstadoCuenta());
		}
	}

}
