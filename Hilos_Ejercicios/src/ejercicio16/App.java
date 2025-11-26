package ejercicio16;

public class App {
	
	// Implementar una simulación de un aeropuerto en el que los aviones deban
	// solicitar el despegue, dirigirse a la pista para despegar, realizar el
	// despegue, volar, solicitar el aterrizaje, realizar la maniobra de
	// aproximación y aterrizar. El despegue y el aterrizaje deberá realizarse en
	// orden del permiso concedido por la torre de control, no pudiendo aterrizar o
	// despegar un avión si la pista está ocupada o tiene otras aeronaves con el
	// permiso ya concedido. Simular la ejecución con 10 aviones.
	
	public static void main(String[] args) {
		AeroPuerto a1 = new AeroPuerto();
		Avion[] aviones = new Avion[10];
		for (int i = 0; i < 10; i++) {
			aviones[i]= new Avion(i,a1);
			aviones[i].start();
		}
	}
}
