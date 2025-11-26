package ejercicio10;


public class App {
	
	// Desarrollar un programa que simule la siguiente situación: Tres amigos
	// (Wellington, Napoleón y Agustina de Aragón), quedan para cenar al estilo de
	// los montes (comer todos del mismo perol con una misma cuchara), por lo que
	// sólo uno puede comer mientras los otros dos esperan. Cada uno de ellos comerá
	// una vez en cada ronda, pero no implica que coman siempre en el mismo orden
	
	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Thread h1 = new Thread(new Hilo("Wellington",t1));
		Thread h2 = new Thread(new Hilo("Napoleón",t1));
		Thread h3 = new Thread(new Hilo("Agustina de Aragón",t1));
		h1.start();
		h2.start();
		h3.start();
	}
}
