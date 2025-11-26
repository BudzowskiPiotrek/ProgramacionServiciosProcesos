package ejercicio13;

public class App {

	// Implementar en Java mediante el uso de hilos sincronizados la siguiente
	// simulación: En un paso de peatones los coches deben ceder a los peatones que
	// desean cruzar la calle. De esta manera, un peatón no podrá cruzar si un coche
	// está pasando en ese momento. Por su parte, un coche no podrá pasar si un
	// peatón está esperando a cruzar o cruzando ya. Los coches circularán siempre
	// en orden, no pudiendo pasar por el paso de peatones adelantando a otros
	// coches. Los peatones sí podrán cruzar antes que otros peatones. Implementar
	// la simulación con 10 coches y cinco peatones.

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
