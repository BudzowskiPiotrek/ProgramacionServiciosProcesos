package practica02;

public class App {

	public static void main(String[] args) {
		HelloThread2 t = new HelloThread2(1);
		t.start();
		HelloThread2 t2 = new HelloThread2(2);
		t2.start();
		
		
	}

}
