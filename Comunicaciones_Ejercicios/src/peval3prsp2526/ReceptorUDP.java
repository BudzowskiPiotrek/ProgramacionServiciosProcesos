package peval3prsp2526;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceptorUDP implements Runnable {
	DatagramSocket socket = null;
	Utiles utiles;

	public ReceptorUDP(DatagramSocket socket, Utiles utiles) {
		this.socket = socket;
		this.utiles = utiles;
	}

	public void run() {
		byte[] datos = new byte[1024];
		DatagramPacket p = new DatagramPacket(datos, datos.length);
		while (Emisor.ejecutado) {
			try {
				socket.receive(p);
				String msg = new String(p.getData(), 0, p.getLength());
				String msgDes = utiles.descriptar(msg);
				System.out.println("Mensaje cifrado del servidor: " + msg);
				System.out.println("Respuesta descifrada delservidor: " + msgDes);
				System.out.println("\nTu mensaje: ");

			} catch (IOException e) {
				System.err.println("ERROR: al recibir mensage");
				System.err.println("Detealle del error: " + e.getMessage());
			}
		}
	}

}
