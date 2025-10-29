package ejercicio15;

public class App {

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Thread consumidor = new Thread(new Consumidor(t1));
		Thread productor = new Thread(new Productor(t1));
		
		consumidor.start();
		productor.start();
	}

}
