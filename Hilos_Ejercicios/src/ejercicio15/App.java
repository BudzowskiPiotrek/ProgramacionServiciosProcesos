package ejercicio15;

public class App {
	
	// Implementa la simulación de movimientos de una cuenta bancaria de forma que,
	// los usuarios podrán ingresar o reintegrar sólo cantidades de 500€. El cajero
	// no permitirá sacar dinero si el saldo actual es inferior a 4000€. Simular el
	// ejercicio para dos usuarios (uno para ingresar y otro para reintegrar) y cada
	// uno realizará diez movimientos. El saldo inicial de la cuenta es de 5000 €.
	// Utilizar bloqueo de objetos para este ejercicio.

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Thread consumidor = new Thread(new Consumidor(t1));
		Thread productor = new Thread(new Productor(t1));

		consumidor.start();
		productor.start();
	}
}
