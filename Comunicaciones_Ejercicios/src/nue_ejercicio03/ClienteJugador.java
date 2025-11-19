package nue_ejercicio03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteJugador {

	public static void main(String[] args) {
		try {
			InetAddress destino = InetAddress.getLocalHost();
			int port = 30000;
			byte[] mensaje = new byte[1024];
			Scanner st = new Scanner(System.in);
			
			ClienteRecibir recibir = new ClienteRecibir();
			recibir.start();
			
			while (true) {
				String enviar = st.nextLine();
				mensaje = enviar.getBytes();
				DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
				enviarATodos(envio);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void enviarATodos(DatagramPacket envio) {
		DatagramSocket socket;
		try {
			for (int i = 0; i < 20; i++) {
				socket = new DatagramSocket(30000 + i);
				socket.send(envio);
				socket.close();
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
