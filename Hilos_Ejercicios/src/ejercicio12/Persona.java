package ejercicio12;

public class Persona extends Thread {
	private Habitacion habitacion;
	private boolean esAbridora;

	public Persona(Habitacion habitacion, boolean esAbridora) { 
		this.habitacion = habitacion;
		this.esAbridora = esAbridora;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			if (esAbridora) {
				habitacion.abrir(this.getName());
			} else {
				habitacion.cerrar(this.getName());
			}
		}
	}
}