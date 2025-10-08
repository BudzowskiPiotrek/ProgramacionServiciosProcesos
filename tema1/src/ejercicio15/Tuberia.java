package ejercicio15;

public class Tuberia {
	private int estadoCuenta = 5000;

	public synchronized void depositar(int cantidad) {
		this.estadoCuenta += cantidad;
		notifyAll();
	}

	public synchronized  void retirar(int cantidad) {
		while (this.estadoCuenta <= 4000) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.estadoCuenta -= cantidad;
	}

	public int getEstadoCuenta() {
		return estadoCuenta;
	}

}
