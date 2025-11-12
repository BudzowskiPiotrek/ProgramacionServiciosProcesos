package ejercicio02;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	private static final int PUERTO = 5000;
	private String mensajeAEnviar;
	private String respuesta;
	private static final String HOST = "192.168.1.4";

	public void initClient() {
		try (Socket cliente = new Socket(HOST, PUERTO);
				DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
				DataInputStream entrada = new DataInputStream(cliente.getInputStream());
				Scanner scanner = new Scanner(System.in)) {

			System.out.println("Conectado al servidor. \nEscribe 'adios' para salir.");

			do {
				System.out.print("CLIENTE: ");
				mensajeAEnviar = scanner.nextLine();

				salida.writeUTF(mensajeAEnviar);
				salida.flush();

				if ("adios".equalsIgnoreCase(mensajeAEnviar)) {
					break;
				}
				respuesta = entrada.readUTF();
				System.out.println(respuesta);

			} while (!cliente.isClosed());

		} catch (UnknownHostException e) {
			System.err.println("Error :" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error :" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.initClient();
	}
}
