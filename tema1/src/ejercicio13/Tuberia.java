package ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Tuberia {

	public List<String> lista = new ArrayList<>();

	public synchronized void pasar(String tipo) {
		lista.add(tipo);
		notifyAll();
	}

	public synchronized void imprimir() {
		String auxTexto = "";
		while (lista.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		if (lista.contains("Peaton")) {
			auxTexto = "Peaton";
			lista.remove("Peaton");

		} else if (lista.contains("Coche")) {
			auxTexto = "Coche";
			lista.remove("Coche");
		}
		
		System.out.println("Ahora pasa el : " + auxTexto);
		notifyAll();
	}
}
