package nue_ejercicio02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMulti {

	public static int numeroSecreto = (int) (Math.random() * 10) + 1;
	public static int turno = 1;
	public static boolean terminado = false;
	
	// Crea un sistema de comunicaciones siguiendo el modelo Cliente-Servidor
	// que permita jugar a acertar un número generado por el servidor. El sistema
	// sólo permitirá tres jugadores como máximo. Se responderá en estricto orden
	// de llegada, no pudiendo contestar si no es su turno. Todos los jugadores
	// verán los intentos de los demás jugadores. El juego acabará cuando uno de
	// los jugadores acierte el número. En este momento, el sistema debe indicárselo
	// al resto de jugadores.

	public static void main(String[] args) {
		try (ServerSocket servidor = new ServerSocket(5000)) {
			System.out.println("Servidor iniciado....");
			int i = 1;
			while (i != 4) {
				Socket cliente = new Socket();
				cliente = servidor.accept();
				HiloServidorMulti hilo = new HiloServidorMulti(cliente, i);
				hilo.start();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
