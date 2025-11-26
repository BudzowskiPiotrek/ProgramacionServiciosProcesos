package practica01;

public class Hilo implements Runnable {
	Thread t;

	public Hilo(int i) {
		t = new Thread(this);
		t.setName("Nuevo Thread" + i);
		System.out.println("Creado hilo " + t.getName());
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(t.getName());
		}
	}
}
