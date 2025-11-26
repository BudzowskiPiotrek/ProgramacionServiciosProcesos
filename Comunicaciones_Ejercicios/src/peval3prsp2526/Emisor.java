package peval3prsp2526;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;

public class Emisor {
	public static boolean ejecutado = true;
	public static void main(String[] args) {
		Utiles utiles = new Utiles();
		Scanner sc = new Scanner(System.in);
		int puertoLocal = 6000;
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(puertoLocal);
			System.out.println("Cliente iniciado");
			System.out.println("Escribe mensajes para enviar al servidor");
			System.out.println("Escribe 'salir' para finalizar");
			
			InetAddress ip = InetAddress.getByName("localhost");
			Thread escuchar = new Thread(new ReceptorUDP(socket, utiles));
			escuchar.start();
			String texto = "";
			while (!texto.equalsIgnoreCase("Salir")) {
				texto = sc.nextLine();
				String cifrado = utiles.criptar(texto);
				byte[] datos = cifrado.getBytes();
				DatagramPacket p = new DatagramPacket(datos, datos.length, ip, 5000);
				try {
					socket.send(p);
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
			if (socket != null) {
				ejecutado = false;
				socket.close();
				System.out.println("Socket cerrado correctamente");
			}
		}
	}
}
