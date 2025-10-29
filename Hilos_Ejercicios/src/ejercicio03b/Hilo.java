package ejercicio03b;

public class Hilo extends Thread {

	Contador c;
	int nombre;

	Hilo(Contador c, int a) {
		this.c = c;
		this.nombre = a;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			c.contar(nombre);
		}
	}

}
