package practica02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

	public static void main(String[] args) {
		byte[] bufer = new byte[1024]; // bufer para
		// recibir el datagrama

		try {
			DatagramSocket socket = new DatagramSocket(12345); // Asociación del socket alpuerto 12345
			// Espera del Datagrama
			System.out.println("Esperando Datagrama.......");
			DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo); // Recibo del datagrama
			int bytesRec = recibo.getLength();// Obtengo número de bytes
			String paquete = new String(recibo.getData()); // Obtengo el String
			// Visualización de la informaci
			System.out.println("Numero de bytes recibidos: " + bytesRec);
			System.out.println("Contenido del paquete: " + paquete.trim());
			System.out.println("Puerto origen del mensaje: " + recibo.getPort());
			System.out.println("IP de origen: " + recibo.getAddress().getHostAddress());
			System.out.println("Puerto destino del mensaje: " + socket.getLocalPort());
			socket.close(); // Cierre del Socket

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
