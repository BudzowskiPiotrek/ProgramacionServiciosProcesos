package ejercicio03b;

public class App {
	// Crear dos hilos que realicen una cuenta común y consecutiva de números:
	// 1, 2, 3, 4, 5, …
	// ¿Qué problema observas en la ejecución?
	public static void main(String[] args) {
		Contador c = new Contador();
		Hilo h1 = new Hilo(c, 1);
		Hilo h2 = new Hilo(c, 2);
		h1.start();
		h2.start();
	}
}
