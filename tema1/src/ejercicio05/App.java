package ejercicio05;

public class App {
	// Crear un programa en el que se realice una carrera de cinco camellos en la
	// que tengan que recorrer 25 m. Cada camello corre de manera independiente
	// y al final de la carrera debe mostrarse el podio.

	public static void main(String[] args) throws InterruptedException {
		Podio podio = new Podio();
		Camello[] lista = new Camello[5];
		for (int i = 0; i < 5; i++) {
			lista[i] = new Camello(i + 1, podio);
		}
		for (int i = 0; i < lista.length; i++) {
			lista[i].start();
		}
		for (int i = 0; i < lista.length; i++) {
			lista[i].join();
		}
		podio.mostrarPodio();

	}

}
