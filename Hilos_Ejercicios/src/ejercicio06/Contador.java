package ejercicio06;

public class Contador {
	
	private int primerDado = 0;
	private int suma;

	public synchronized void resultado(int dado) {
		if (primerDado == 0) {
			primerDado = dado;
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		} else {
			suma = primerDado + dado;
			System.out.println("La suma de los dados es: " + suma);

			if (suma == 2) {
				System.out.println("Snake-eyes, perdiste");
			} else if (suma == 7 || suma == 11) {
				System.out.println("Has ganado");
			} else {
				System.out.println("Tira otra vez");
			}
			primerDado = 0;
			suma = 0;
			notifyAll();
		}
	}
}
