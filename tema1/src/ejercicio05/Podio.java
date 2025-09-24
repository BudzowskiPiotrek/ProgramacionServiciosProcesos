package ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Podio {
    private List<String> ordenLlegada = new ArrayList<>();

    public synchronized void registrarLlegada(String nombreCamello) {
        ordenLlegada.add(nombreCamello);
        System.out.println("¡" + nombreCamello + " ha llegado!");
    }

    public void mostrarPodio() {
        System.out.println("\nP-O-D-I-O");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "º: " + ordenLlegada.get(i));
        }
    }
}