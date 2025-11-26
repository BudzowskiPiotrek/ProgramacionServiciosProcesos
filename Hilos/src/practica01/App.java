package practica01;

public class App {

	public static void main(String[] args) {
		Thread h1 = new Thread(new Hilo(1));
		Thread h2 = new Thread(new Hilo(2));
		h1.start();
		h2.start();
	}
}
