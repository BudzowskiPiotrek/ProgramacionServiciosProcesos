package peval2prsp2526;

public class Proyecto extends Thread {
	private String nombre;
	private int tiempo;
	private Impresora impresora;

	public Proyecto(String nombre, Impresora impresora) {
		this.nombre = nombre;
		this.tiempo = (int) (6 * Math.random() + 1);
		this.impresora = impresora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Impresora getImpresora() {
		return impresora;
	}

	public void setImpresora(Impresora impresora) {
		this.impresora = impresora;
	}

	public void run() {
		impresora.asignarTurno(this);
		impresora.imprimir(this);	
		System.out.println("///////////Proyecto " + nombre + " ha finalizado de imprimirse");
	}


}
