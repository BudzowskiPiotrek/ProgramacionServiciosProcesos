package exa1prsp2526;

public class Main {

	public static void main(String[] args) {
		EstacionCarga ec = new EstacionCarga();
		for (int i = 0; i < 4; i++) {
			Thread t1 = new Thread(new Robot(i, ec));
			t1.start();
		}
		for (int i = 0; i < 2; i++) {
			Thread t1 = new Thread(new Supervisor(i, ec));
			t1.start();
		}
	}
}
