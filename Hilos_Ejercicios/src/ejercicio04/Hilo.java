package ejercicio04;

public class Hilo extends Thread {
    private Contador contador;

    public Hilo(Contador contador, String nombre) {
        super(nombre);
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            contador.incrementar();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
