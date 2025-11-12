package ejercicio02;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Servidor {
	private static final int PUERTO = 12345;
	String mensajeRecibido;
	String mensaje;
	private Scanner sn = new Scanner(System.in);

	public void initServer() {
		try (ServerSocket servidor = new ServerSocket(PUERTO)) {
			System.out.println("Esperando conexión en el puerto " + PUERTO + "...");

			while (true) {
				try (Socket socket = servidor.accept();
						DataInputStream entrada = new DataInputStream(socket.getInputStream());
						DataOutputStream salida = new DataOutputStream(socket.getOutputStream()))
						 {

					System.out.println("Cliente conectado desde: " + socket.getInetAddress().getHostAddress());

					while (!socket.isClosed()) {

						mensajeRecibido = entrada.readUTF();

						if ("adios".equalsIgnoreCase(mensajeRecibido)) {
							System.out.println("Cliente ha dicho adios.");
							break;
						}
						System.out.println("CLIENTE: " + mensajeRecibido);
						System.out.print("Servidor: ");
						mensaje = "Servidor: " + sn.nextLine();
						salida.writeUTF(mensaje);
						salida.flush(); // PARA FORZAR MANDAR MENSAJES
					}

				} catch (EOFException | SocketException e) {
					System.err.println("Error :" + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error :" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Servidor s = new Servidor();
		s.initServer();
	}
}