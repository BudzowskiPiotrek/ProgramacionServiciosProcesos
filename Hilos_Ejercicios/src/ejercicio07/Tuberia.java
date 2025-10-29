package ejercicio07;

public class Tuberia {

	private char buffer[] = new char[6];
	private int siguente = 0;

	public char recoger() {
		siguente--;
		return buffer[siguente];
	}

	public void lanzar(char c) {
		buffer[siguente] = c;
		siguente++;
	}

}
