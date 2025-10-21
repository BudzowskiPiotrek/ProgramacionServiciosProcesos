package ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class AeroPuerto {

	private List<String> lista = new ArrayList<>();
	private List<String> pista = new ArrayList<>();

	public void solicitarDespegue(int numero) throws InterruptedException {
		System.out.println("El avion con nº: " + numero + "solicita el despegue");
		synchronized (lista) {
			lista.add("Avion: " + numero);
			System.out.println("El avion: " + numero + " se esta dirigiendo a pista de despegue");
			dirigirsePista(numero);
		}
		vuelo(numero);
	}

	public synchronized void dirigirsePista(int numero) throws InterruptedException {
		while (!pista.isEmpty()) {
			wait();
		}
		lista.remove("Avion: " + numero);
		pista.add("Avion: " + numero);
		Thread.sleep(1000);
		System.out.println("El avion numero: " + numero + "Ha despegado");
		pista.remove("Avion: " + numero);
		
		this.notifyAll();
	}

	public void vuelo(int numero) throws InterruptedException {
		Thread.sleep((long) (0000 * Math.random()));
		Aterizar(numero);
	}

	public synchronized void Aterizar(int numero) throws InterruptedException {
		while (!pista.isEmpty()) {
			wait();
		}
		pista.add("Avion: " + numero);
		Thread.sleep(1000);
		System.out.println("El avion numero: " + numero + "Ha aterizado");
		pista.remove("Avion: " + numero);
		notifyAll();
	}
}
