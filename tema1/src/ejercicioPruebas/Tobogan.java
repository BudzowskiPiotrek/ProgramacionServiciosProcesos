package ejercicioPruebas;

import java.util.ArrayList;
import java.util.List;

public class Tobogan {
	private List<Nino> lista = new ArrayList<>();
	private boolean libre = true;
	private int total = 1;

	public synchronized void hacerLaCola(Nino nino) {
		lista.add(nino);
		notifyAll();
	}

	public synchronized void bajarAtraccion() {
		while (total <= 10) {
			if(lista.isEmpty()) {
				try {
					wait();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (libre && !lista.isEmpty()) {
				System.out.println("Bajando " + lista.get(0).getNombre());
				lista.remove(0);
				libre=false;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("El tobogan vuelve estar libre");
			libre=true;
			total++;
		}
		System.out.println("LLegamos al limite de atraccion, se cierra");
	}

}
