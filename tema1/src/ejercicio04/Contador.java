package ejercicio04;

public class Contador {
	private int n = 0;

	public void incrementar() {
		System.out.print(Thread.currentThread().getName() + " - " + n++ + ", ");
		
	}
}