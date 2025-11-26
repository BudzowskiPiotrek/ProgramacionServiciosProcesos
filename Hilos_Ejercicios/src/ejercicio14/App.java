package ejercicio14;

public class App {

	// En una intersección de una carretera, circulan bicis, coches y camiones.
	// Según las señales de tráfico que regulan el cruce, las bicicletas tienen
	// preferencia sobre los coches y camiones, y los coches tienen preferencia
	// sobre los camiones.

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Productor bici = new Productor(t1, 5);
		Productor coche = new Productor(t1, 5);
		Productor camion = new Productor(t1, 5);
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
