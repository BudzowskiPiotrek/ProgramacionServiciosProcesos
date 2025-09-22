package ejercicio3;

public class App {
	// Crear dos hilos que realicen una cuenta común y consecutiva de números:
	// 1, 2, 3, 4, 5, …
	// ¿Qué problema observas en la ejecución?
	public static void main(String[] args) {
		Thread t1 = new Thread(new Hilo(1));
		Thread t2 = new Thread(new Hilo(2));
		t1.start();
		t2.start();
	}

}
