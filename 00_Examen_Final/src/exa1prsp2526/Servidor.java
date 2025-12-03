package exa1prsp2526;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		int puerto = 5000;

		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor inicializado en puerto " + puerto);
			Socket cliente;
			while (true) {
				cliente = servidor.accept();
				Thread servidorHilo = new Thread(new ServidorHilo(cliente));
				servidorHilo.start();
			}
		} catch (IOException e) {
			System.err.println("Error al inicializar el servidor en puesto: " + puerto);
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}
}
