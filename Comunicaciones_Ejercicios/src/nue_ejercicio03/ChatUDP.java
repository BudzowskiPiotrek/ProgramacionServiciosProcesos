package nue_ejercicio03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatUDP {
	public static void main(String[] args) {
		int puertoLocal = 5001;
		int puertoMin = 5000;
		int puertoMax = 5005;
		String tuNombre = "Pio";

		DatagramSocket socket = null;

		try {
		    socket = new DatagramSocket(puertoLocal);
		    socket.setBroadcast(true);

		    InetAddress ip = InetAddress.getByName("255.255.255.255");

		    System.out.println("Chat UDP escuchando en puerto " + puertoLocal);
		    System.out.println("Enviará mensajes a puertos " + puertoMin + " a " + puertoMax);

		    // Hilo para recibir mensajes
		    Thread receptor = new Thread(new ReceptorUDP(socket, tuNombre));
		    receptor.start();

		    Scanner br = new Scanner(System.in);
		    String texto;

		    System.out.println("Cliente listo. Escribe para enviar:");

		    while (true) {
		        texto = "[" + tuNombre + "]: " + br.nextLine();
		        byte[] datos = texto.getBytes();

		        for (int p = puertoMin; p <= puertoMax; p++) {
		            if (p == puertoLocal)
		                continue;

		            try {
		                DatagramPacket paquete = new DatagramPacket(datos, datos.length, ip, p);
		                socket.send(paquete);
		            } catch (IOException e) {
		                System.err.println("Error enviando al puerto " + p + ". El mensaje no se pudo entregar.");
		            }
		        }
		    }

		} catch (SocketException e) {
		    System.err.println("No se pudo abrir el socket UDP en el puerto " + puertoLocal 
		                       + ". ¿Está ya en uso?");
		} catch (UnknownHostException e) {
		    System.err.println("La dirección de broadcast no es válida.");
		} catch (Exception e) {
		    System.err.println("Error inesperado en el cliente UDP: " + e.getMessage());
		} finally {
		    if (socket != null && !socket.isClosed()) {
		        socket.close();
		        System.out.println("Socket cerrado correctamente.");
		    }
		}
	}
}