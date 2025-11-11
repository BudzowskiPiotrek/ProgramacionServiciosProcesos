package ejercicio00;

import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor {
	private static final int PUERTO = 12345;

	ServerSocket servidor = null;
	Socket socket = null;
	DataInputStream entrada = null;
	String mensajeRecibido;

	public void initServer() {
		try {
			InetAddress destino = InetAddress.getLocalHost();
			System.out.println(destino);
			servidor = new ServerSocket(PUERTO);
			System.out.println("Waiting connection on port " + PUERTO);
			socket = servidor.accept();
			System.out.println("Client connected from: " + socket.getInetAddress().getHostAddress());
			entrada = new DataInputStream(socket.getInputStream());
			mensajeRecibido = entrada.readUTF();
			System.out.println("El Cliente dice....\"" + mensajeRecibido + "\"");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Servidor s = new Servidor();
		s.initServer();
	}
}