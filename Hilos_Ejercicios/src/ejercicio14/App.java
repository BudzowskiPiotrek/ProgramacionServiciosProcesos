package ejercicio14;

public class App {

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Productor bici = new Productor(t1,5);
		Productor coche = new Productor(t1,5);
		Productor camion = new Productor(t1,5);
		Consumidor c1 = new Consumidor(t1);
		bici.setName("Bici");
		coche.setName("Coche");
		camion.setName("Camion");
		
		bici.start();
		coche.start();
		camion.start();
		c1.start();
		
	}

}
