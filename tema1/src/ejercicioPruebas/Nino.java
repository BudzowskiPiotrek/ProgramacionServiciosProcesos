package ejercicioPruebas;


public class Nino extends Persona implements Runnable {
	Thread t;
	private Tobogan tobogan;

	public Nino(String nombre, Tobogan tobogan) {
		super(nombre);
		t = new Thread(this);
		this.tobogan = tobogan;
	}

	public void run() {
		System.out.println("El niño " + this.getNombre() + " esta subiendo");
		try {
			Thread.sleep((long) (10000 * Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tobogan.hacerLaCola(this);
	}

}
