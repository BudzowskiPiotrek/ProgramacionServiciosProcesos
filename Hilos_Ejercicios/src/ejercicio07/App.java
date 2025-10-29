package ejercicio07;

public class App {
	// Implementar una solución al problema clásico del Productor-Consumidor,
	// utilizando hilos.
	// Nota: Implementa un retardo en la recepción del dato por parte del
	// consumidor.
	// ¿Qué ocurre si no insertamos el retardo?
	// ¿Qué problemas se nos pueden dar durante la ejecución?

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Productor p1 = new Productor(t1);
		Consumidor c1 = new Consumidor(t1);
		p1.start();
		try {
			p1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.start();

	}

}
