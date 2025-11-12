package ejercicio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMulti {

	public static void main(String[] args) {
		try (ServerSocket servidor = new ServerSocket(5000)) {
			System.out.println("Servidor iniciado....");
			while (true) {
				Socket cliente = new Socket();
				cliente = servidor.accept();
				HiloServidorMulti hilo = new HiloServidorMulti(cliente);
				hilo.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
