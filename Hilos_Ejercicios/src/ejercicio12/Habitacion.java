package ejercicio12;

public class Habitacion {
	private Puerta puerta = new Puerta();

	public synchronized void abrir(String name) {
        while (puerta.isAbierta()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        puerta.setAbierta(true);
        System.out.println(name + " ha abierto la puerta.");
        notifyAll(); 
    }

	public synchronized void cerrar(String name) {
		 while (!puerta.isAbierta()) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        puerta.setAbierta(false);
	        System.out.println(name + " ha cerrado la puerta.");
	        notifyAll(); 
	    }
}
