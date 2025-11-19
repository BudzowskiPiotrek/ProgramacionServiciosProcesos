package nue_ejercicio04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMulti {
	
	// Crea un chat de comunicaciones siguiendo el modelo Cliente-Servidor que
	// permita la comunicación bidireccional entre todos los usuarios. Cuando un
	// usuario se conecte al chat, los demás usuarios que estén conectados deberán
	// ser avisados. Los mensajes de un usuario deberán ser recibidos por todos los
	// usuarios que estén conectados. Un usuario se desconectará cuando escriba
	// “FIN”. En este momento se avisará a los demás usuarios de su desconexión.
	
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
