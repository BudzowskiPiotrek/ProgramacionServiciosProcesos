package peval2prsp2526;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Impresora {
	private boolean ocupada;
	private ArrayList<Proyecto> lista;

	public Impresora() {
		this.ocupada = false;
		this.lista = new ArrayList<>();
	}

	public void asignarTurno(Proyecto p) {
		System.out.println("\033[92mEl Proyecto " + p.getNombre() + " ha sido recibido en la cola de impresion\033[37m");
		
		synchronized (lista) {
			lista.add(p);
			lista.sort(Comparator.comparingInt(Proyecto::getTiempo));
		}
		
		
	}

	public synchronized void imprimir(Proyecto p) {
		while (p != lista.get(0)) {
			try {
				System.out.println(p.getNombre() +" debe esperar");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("///////////El Proyecto " + p.getNombre() + " comienza imprimirse");
		try {
			Thread.sleep(1000 * p.getTiempo());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lista.remove(0);
		System.out.println("\033[31mProyecto " + p.getNombre() + " ha sido eliminado en lacola de imprecion\033[37m");
		notifyAll();
	}

}

