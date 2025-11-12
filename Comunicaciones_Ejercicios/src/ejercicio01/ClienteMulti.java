package ejercicio01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteMulti {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 5000;
		System.out.println();
		Socket cliente = new Socket(host, puerto);

		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

		String cadena = "";
		RecibirHilo recibir = new RecibirHilo(flujoEntrada);
		recibir.start();
		System.out.println("[Pulsa enter para mandar mensaje, escribe '*' para terminar]");
		while (!cadena.equals("*")) {
			
			cadena = sc.nextLine();
			flujoSalida.writeUTF(cadena);
		}
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();

	}
}
