package peval2prsp2526;

import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		Impresora impresora = new Impresora();
		Proyecto[] lista = new Proyecto[20];
		System.out.println("Laboratorio abierto.");
		for (int i = 0; i < 20; i++) {
			lista[i] = new Proyecto("P" + (i + 1), impresora);
			lista[i].start();

		}
		System.out.println("Todos los proyectos han sido recepcionados.");

		for (int i = 0; i < 20; i++) {
			try {
				lista[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Todos Proyectos fueron imprimidos");
	}
}
