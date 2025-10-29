package ejercicio08;

public class App {
	// Implementar la siguiente situación mediante hilos sincronizados: En un
	// castillo, el rey va a realizar una audiencia a tres caballeros de la corte,
	// Cuando el rey llegue a la audiencia, saludará a sus caballeros diciendo:
	// “BUENOS DÍAS SÚBDITOS”, contestando éstos: “BUENOS DÍAS MAJESTAD”. Ningún
	// caballero hablará hasta que no lo haya hecho el rey.

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
