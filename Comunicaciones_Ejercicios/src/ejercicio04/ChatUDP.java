package ejercicio04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatUDP {
	public static void main(String[] args) throws Exception {
		int puertoLocal = 5001;
		int puertoMin = 5000;
		int puertoMax = 5005;
		String tuNombre = "Pio";

		DatagramSocket socket = new DatagramSocket(puertoLocal);
		socket.setBroadcast(true); // activar mandar mensajes a la red
		
		InetAddress ip =  InetAddress.getByName("255.255.255.255");

		System.out.println("Chat UDP escuchando en puerto " + puertoLocal);
		System.out.println("Enviará mensajes a puertos " + puertoMin + " a " + puertoMax);

		// Hilo para recibir mensajes
		Thread receptor = new Thread(new ReceptorUDP(socket, tuNombre));
		receptor.start();

		Scanner br = new Scanner(System.in);
		String texto;

		System.out.println("Adivina un Numero entre 1 a 100:");

		while (true) {
			texto = br.nextLine();
			byte[] datos = texto.getBytes();

			// Mando al rango que decidi antes sin enviarme a mi.
			for (int p = puertoMin; p <= puertoMax; p++) {
				if (p == puertoLocal)
					continue;
				DatagramPacket paquete = new DatagramPacket(datos, datos.length, ip, p);
				socket.send(paquete);
			}
		}
	}
}
