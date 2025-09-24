package ejercicio06;

import java.util.Random;

public class Hilo extends Thread {

	@Override
	public void run() {
		Random random = new Random();
		int dado1, dado2, suma;

		System.out.println("Start");
		do {
			dado1 = random.nextInt(6) + 1;
			dado2 = random.nextInt(6) + 1;
			suma = dado1 + dado2;
			System.out.println("Dado 1 : " + dado1 + " Dado 2 : " + dado2 + " SUma : " + suma);

			if (suma == 2) {
				System.out.println("Has perdido");
			} else if (suma == 7 || suma == 11) {
				System.out.println("Has ganado");
			} else {
				System.out.println("Tira de nuevo...");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					
				}
			}
		} while (suma != 2 && suma != 7 && suma != 11);
	}
}