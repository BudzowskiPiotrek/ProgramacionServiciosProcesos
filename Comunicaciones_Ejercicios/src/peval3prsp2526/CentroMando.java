package peval3prsp2526;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CentroMando {

	public static void main(String[] args) {
		Utiles utiles = new Utiles();
		int puertoLocal = 5000;
		Scanner sc = new Scanner(System.in);
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(puertoLocal);
			System.out.println("Servidor operativo, y escuchando!");
			byte[] datos = new byte[1024];
			DatagramPacket p = new DatagramPacket(datos, datos.length);
			while (true) {
				socket.receive(p);
				String msg = new String(p.getData(), 0, p.getLength());
				String msgDes = utiles.descriptar(msg);
				System.out.println("Direccion ip del cliete: " + p.getAddress());
				System.out.println("Puerto del cliente: " + p.getPort());
				System.out.println("Mensaje cifrado: " + msg);
				System.out.println("Mensaje descifrado: " + msgDes);

				String texto = "Recibido: " + msgDes;

				String textoCif = utiles.criptar(texto);
				datos = textoCif.getBytes();
				DatagramPacket enviar = new DatagramPacket(datos, datos.length, p.getAddress(), p.getPort());
				try {
					socket.send(enviar);
				} catch (IOException e3) {
					System.out.println("Error al intentar mandar mensaje");
				}
			}

		} catch (SocketException e) {
			System.err.println("ERROR : No se pudo abrir Socket en " + puertoLocal);
		} catch (UnknownHostException e1) {
			System.out.println("ERROR : la direccion el Ip no es valida");
			System.out.println("Detalle del error : " + e1.getMessage());
		} catch (IOException e2) {
			System.out.println("ERROR  inesperado");
			System.out.println("Detalle del error : " + e2.getMessage());
		} finally {
			if (socket != null && socket.isClosed()) {
				socket.close();
				System.out.println("Socket cerrado correctamente");
			}
		}

	}
}
