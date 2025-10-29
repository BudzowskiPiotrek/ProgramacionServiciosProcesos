package ejercicio12;

public class App {

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
