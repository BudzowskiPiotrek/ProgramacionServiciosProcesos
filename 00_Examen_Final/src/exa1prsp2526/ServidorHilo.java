package exa1prsp2526;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServidorHilo implements Runnable {

	private Socket socket;

	private DataInputStream entrada;
	public boolean ejecutado = true;

	public ServidorHilo(Socket cliente) {
		this.socket = cliente;
		try {
			entrada = new DataInputStream(cliente.getInputStream());
		} catch (IOException e) {
			System.err.println("Error al intentar inicializar conexion de entrada y salida ");
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}

	@Override
	public void run() {
		while (ejecutado) {
			try {
				String mensaje = entrada.readUTF();
				System.out.println("Servidor recibio:" + mensaje);
				if (socket == null) {
					ejecutado = false;
				}
			} catch (IOException e) {
				ejecutado = false;
					System.err.println("Error en intento de recibir mensaje...");
					System.err.println("Detalle de error: " + e.getMessage());
			}
		}
	}
}
