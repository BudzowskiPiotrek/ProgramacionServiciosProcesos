package ejercicio10;

public class Tuberia {
private int totalRonda=0;

	public synchronized void comer(String nombre) {
		System.out.println("Ahora come con cuchara "+ nombre);
		totalRonda++;
		if(totalRonda==3) {
			notifyAll();
			totalRonda=0;
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
