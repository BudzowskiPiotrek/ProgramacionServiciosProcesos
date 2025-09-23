package ejercicio02;

public class Hilo implements Runnable {
	Thread t;
	String color;
	private final String RESET = "\u001b[0m";

	public Hilo(String color) {
		this.color = color;
		t = new Thread(this);
		t.setName("Nuevo hilo de color " + this.color);
		System.out.println("Creado hilo " + t.getName());
	}

	public void run() {
		switch (color) {
		case "VERDE":
			System.out.println("\u001b[32mHola, el mundo es de color [" + color + "]" + RESET);
			break;
		case "ROJO":
			System.out.println("\u001b[31mHola, el mundo es de color [" + color + "]" + RESET);
			break;
		case "AMARILLO":
			System.out.println("\u001b[33mHola, el mundo es de color [" + color + "]" + RESET);
			break;
		default:
			System.err.println("NO DISPONEMOS DE ESTE COLOR");
			break;
		}
	}
}
