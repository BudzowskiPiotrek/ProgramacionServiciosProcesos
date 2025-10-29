package ejercicio13;

public class App {

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Productor coche = new Productor("Coche", 10, t1);
		Productor peaton = new Productor("Peaton", 5, t1);
		Consumidor c1 = new Consumidor(t1);
		coche.start();
		peaton.start();
		c1.start();
	}
}
