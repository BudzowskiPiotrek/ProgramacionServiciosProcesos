package ejercicio11;

public class Tuberia {

	private String ultimoColor = "";

	public synchronized void cambioSemaforo(String color) throws InterruptedException {
		if (ultimoColor.equalsIgnoreCase("")) {
			ultimoColor = color;
		} else {

			if (color.equalsIgnoreCase("Amarillo")) {
				while (!ultimoColor.equalsIgnoreCase("Rojo")) {
					wait();
				}
				ultimoColor = color;
			} else if (color.equalsIgnoreCase("Verde")) {
				while (!ultimoColor.equalsIgnoreCase("Amarillo")) {
					wait();
				}
				ultimoColor = color;
			} else if (color.equalsIgnoreCase("Rojo")) {
				while (!ultimoColor.equalsIgnoreCase("Verde")) {
					wait();
				}
				ultimoColor = color;
			}
		}
		System.out.println(color);
		notifyAll();
	}
}
