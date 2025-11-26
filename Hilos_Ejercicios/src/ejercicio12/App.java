package ejercicio12;

public class App {

	// Simular mediante un programa java la siguiente situación: En una habitación
	// hay una puerta y dos personas que tienen por costumbre abrir y cerrar la
	// puerta constantemente. Pero no podrán abrir la puerta si ya está abierta o
	// cerrarla si ya está cerrada, por lo que deberán esperarse a que ésta esté en
	// la posición apropiada para realizar la acción correspondiente.

	public static void main(String[] args) {
		Habitacion miHabitacion = new Habitacion();
		Persona persona1 = new Persona(miHabitacion, true);
		Persona persona2 = new Persona(miHabitacion, false);
		persona1.setName("Alice");
		persona2.setName("Bob");
		persona1.start();
		persona2.start();
	}
}
