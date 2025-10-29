package ejercicio09;

import ejercicio08.Hilo;
import ejercicio08.Tuberia;

public class App {
	// Modifica el programa anterior para que el rey no hable hasta que no estén
	// todos los caballeros, y éstos no hablen hasta que el rey no haya saludado.

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Hilo rey = new Hilo("Rey", "BUENOS DÍAS SÚBDITOS\n", t1);
		Hilo s1 = new Hilo("Subdito 1", "BUENOS DÍAS MAJESTAD", t1);
		Hilo s2 = new Hilo("Subdito 2", "BUENOS DÍAS MAJESTAD", t1);
		Hilo s3 = new Hilo("Subdito 2", "BUENOS DÍAS MAJESTAD", t1);
		rey.start();
		s1.start();
		s2.start();
		s3.start();
	}

}
