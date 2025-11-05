package peval1prsp2526;

public class Atracion {

	public static void main(String[] args) {
		Thread[] lista = new Thread[10];
		Tobogan tobogan = new Tobogan();

		for (int i = 0; i < lista.length; i++) {
			lista[i] = new Thread(new Nino("Niño " + (i + 1), tobogan));
			lista[i].start();
		}
		tobogan.bajarAtraccion();
	}
}
