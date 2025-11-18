package practica01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class App {

	public static void main(String[] args) {
		try {
			InetAddress destino = InetAddress.getLocalHost();
			int port = 12345; // Puerto al que envío el datagrama
			byte[] mensaje = new byte[1024];

			String Saludo = "enviado saludos !!";
			mensaje = Saludo.getBytes(); // codifico String a bytes

			// CONSTRUYO EL DATAGRAMA A ENVIAR
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
			DatagramSocket socket = new DatagramSocket(34567);// Puerto local
			System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
			System.out.println("IP destino: " + destino.getHostAddress());
			System.out.println("Host destino: " + destino.getHostName());
			System.out.println("Puerto local del socket: " + socket.getLocalPort());
			System.out.println("Puerto al que envio: " + envio.getPort());
			// ENVÍO DEL DATAGRAMA
			socket.send(envio);
			socket.close(); // cierro el socket
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
