package ejercicio15;

public class Tuberia {
	
	private int estadoCuenta = 5000;

	public void actuar(int cantidad) {
		System.out.println("entrando al cajero");
		
		synchronized (this) {
			while (this.estadoCuenta <= 4000) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			estadoCuenta +=cantidad;
			notifyAll();
		}
	}

	public int getEstadoCuenta() {
		return estadoCuenta;
	}
}
