package ejercicio07;

public class App {

	public static void main(String[] args) {
		Tuberia t1 = new Tuberia();
		Productor p1 = new Productor(t1);
		Consumidor c1 = new Consumidor (t1);
		p1.start();
		try {
			p1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.start();
		
	}

}
