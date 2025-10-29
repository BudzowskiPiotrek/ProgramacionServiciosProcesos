package ejercicio04;

public class App {
	// Crea dos hilos para realizar una cuenta común y consecutiva de números de
	// forma alterna.
	// Es decir: Th0-1, Th1-2, Th0-3, Th1-4, ...
	public static void main(String[] args) {
		Contador contador = new Contador();
		Hilo hilo0 = new Hilo(contador, "Th0");
		Hilo hilo1 = new Hilo(contador, "TH1");
		hilo0.start();
		hilo1.start();
	}
}