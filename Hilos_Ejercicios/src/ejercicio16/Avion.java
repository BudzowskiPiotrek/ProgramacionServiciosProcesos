package ejercicio16;

public class Avion extends Thread {
	private int numero;

	private AeroPuerto puerto;

	public Avion(int numero, AeroPuerto puerto) {
		this.numero = numero;
		this.puerto = puerto;
	}

	public void run() {
		try {
			puerto.solicitarDespegue(numero);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
