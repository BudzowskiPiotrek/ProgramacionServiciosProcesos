package ejercicio06;

public class App {
	// Implementa el juego de dados del “Snake-eye” de manera que haya que
	// lanzar dos dados y si se obtiene la puntuación de 2, el jugador ha perdido.
	// En el caso de que el resultado sea de 11 o siete, el jugador ha ganado. En
	// cualquier otro caso, debe lanzar de nuevo los datos.
	public static void main(String[] args) {
		Contador c1 = new Contador();
		Hilo dado1 = new Hilo(1, c1);
		Hilo dado2 = new Hilo(2, c1);
		dado1.start();
		dado2.start();
	}
}
