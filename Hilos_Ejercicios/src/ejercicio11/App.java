package ejercicio11;

public class App {
	
	// Implementar mediante un programa Java la simulación de un semáforo en el que
	// la secuencia de luces sea el tradicional Verde – Ámbar – Rojo. La secuencia
	// deberá repetirse 10 veces.
	
	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Thread rojo = new Thread(new Hilo(t1, "Rojo"));
		Thread verde = new Thread(new Hilo(t1, "Verde"));
		Thread amarillo = new Thread(new Hilo(t1, "Amarillo"));
		verde.start();
		amarillo.start();
		rojo.start();
	}
}
