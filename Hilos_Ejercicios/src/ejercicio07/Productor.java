package ejercicio07;

public class Productor extends Thread {

	private Tuberia tuberia;
	private String alfabeto = "ABCDEFG";

	public Productor(Tuberia tuberia) {
		super();
		this.tuberia = tuberia;
	}

	public void run() {
		char c;
		c = alfabeto.charAt((int) (Math.random() * alfabeto.length()));
		tuberia.lanzar(c);
		System.out.println("Lanzado" + c + "a la tuberia.");
	}

}
