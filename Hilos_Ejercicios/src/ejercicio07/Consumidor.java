package ejercicio07;

public class Consumidor extends Thread {
	private Tuberia tuberia;

	public Consumidor(Tuberia tuberia) {
		this.tuberia = tuberia;
	}

	public void run() {
		char c;
		c = tuberia.recoger();
		System.out.println("Recogido el caracter " + c);
	}

}
