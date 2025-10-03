package ejercicio09;

public class Tuberia {
	private int subditosLlegados = 0;
	private boolean reySaludado = false;
	
	public synchronized void saluda(String tipo, String saludo) {
		if (tipo.equalsIgnoreCase("Rey")) {
			while (subditosLlegados < 3) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(saludo);
			reySaludado = true;
			notifyAll();
		} else {
			subditosLlegados++;
			if (subditosLlegados == 3) {
				notifyAll();
			}

			while (!reySaludado) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(saludo);
		}
	}
}