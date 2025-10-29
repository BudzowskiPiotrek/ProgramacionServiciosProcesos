package practica02;

public class HelloThread2 extends Thread {

	public HelloThread2(int i) {
		this.setName("Nuevo Thread"+i);
		System.out.println("Creado hilo " + this.getName());
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getName());
		}
	}
}
