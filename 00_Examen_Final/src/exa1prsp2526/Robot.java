package exa1prsp2526;

public class Robot implements Runnable {
	private int prioridad;
	private int numero;
	private EstacionCarga ec;

	public Robot(int numero, EstacionCarga ec) {
		this.numero = numero;
		this.prioridad = (int) (3 * Math.random()) + 1;
		this.ec = ec;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			limpieza();
			ec.solicitarLaCarga(numero, this);
			ec.laCarga(numero, this);
			ec.terminarLaCarga(numero, this);
		}
	}

	private void limpieza() {
		System.out.println("El super robot TurboEnriqueRT00" + numero + " Esta limpiando");
		try {
			Thread.sleep((long) (1000 * Math.random()));
		} catch (InterruptedException e) {
			System.err.println("Error al con tiempo durante la limpieza");
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}
}
