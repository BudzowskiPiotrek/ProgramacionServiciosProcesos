package ejercicio03b;

public class Hilo extends Thread{

	Contador c;

	Hilo(Contador c) {
		this.c = c;
	}
	public void run(){
		for (int i = 0; i < 100; i++) {
			c.contar();
			c.imprimir();
		}
	}

}
