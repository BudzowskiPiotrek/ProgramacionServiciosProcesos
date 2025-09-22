package ejercicio1;

public class Hilo extends Thread {

	public Hilo(int i) {
		this.setName("Hilo nº " + i);
		System.out.println("Creado hilo " + this.getName());
	}

	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(this.getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
