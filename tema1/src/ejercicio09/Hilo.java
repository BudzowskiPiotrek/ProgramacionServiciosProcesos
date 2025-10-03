package ejercicio09;

import ejercicio08.Tuberia;

public class Hilo extends Thread {
	private String tipo;
	private String saludo;
	private Tuberia tuberia;
	
	public Hilo(String tipo, String saludo, Tuberia tuberia) {
		this.tipo = tipo;
		this.saludo = saludo;
		this.tuberia = tuberia;
	}
	
	public void run() {
		tuberia.saluda(tipo, saludo);
	}
}