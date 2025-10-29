package ejercicio03b;

public class App {

	public static void main(String[] args) {
		Contador c = new Contador();
		Hilo h1 = new Hilo(c, 1);
		Hilo h2 = new Hilo(c, 2);
		h1.start();
		h2.start();
	}

}
