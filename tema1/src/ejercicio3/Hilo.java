package ejercicio3;

public class Hilo implements Runnable {
	Thread t;
	public static int numero;

	public Hilo(int i) {
		t = new Thread(this);
		t.setName("Nuevo hilo de color " + i);
		System.out.println("Creado hilo " + t.getName());
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(t.getName()+"numero : " + numero);
			numero++;
		}
		
	}
}

