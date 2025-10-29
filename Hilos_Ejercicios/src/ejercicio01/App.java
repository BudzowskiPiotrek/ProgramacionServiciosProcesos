package ejercicio01;

public class App {
	// Crear dos hilos en el que cada uno de ellos escriba una serie de números
	// desde el 0 al 499, también deberá mostrar el identificador del hilo. Cada
	// hilo deberá esperar 500 milisegundos entre número y número escrito.
	public static void main(String[] args) {
		Hilo h1 = new Hilo(1);
		Hilo h2 = new Hilo(2);
		h1.start();
		h2.start();
	}

}
