package nue_ejercicio03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClienteJuego {

	// Crea un sistema de comunicaciones no orientado a la conexión para jugar a
	// adivinar un número. El usuario podrá contestar sin tener en cuenta el orden
	// de conexión. Cada vez que un usuario diga un número, el servidor deberá
	// decirle si el número que busca es mayor o menor que el que ha introducido. Si
	// un usuario no recibe respuesta del servidor en un tiempo prudencial, se le
	// mostrará un mensaje y se cerrará la conexión.

	public static void main(String[] args) throws Exception {

		int puertoServidor = 5000;
		DatagramSocket socket = new DatagramSocket(puertoServidor);

		int numeroSecreto = (int) (Math.random() * 100) + 1;
		System.out.println("Servidor iniciado. Número secreto: " + numeroSecreto);

		byte[] buffer = new byte[1024];

		while (true) {

			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
			socket.receive(paquete);

			String recibido = new String(paquete.getData(), 0, paquete.getLength());
			int intento = Integer.parseInt(recibido);

			System.out.println("Cliente " + paquete.getAddress() + ":" + paquete.getPort() + " dijo: " + intento);

			String respuesta;

			if (intento < numeroSecreto)
				respuesta = "MAYOR";
			else if (intento > numeroSecreto)
				respuesta = "MENOR";
			else
				respuesta = "CORRECTO";

			// Enviar respuesta al cliente
			byte[] datos = respuesta.getBytes();
			DatagramPacket respuestaPaquete = new DatagramPacket(datos, datos.length, paquete.getAddress(),
					paquete.getPort());

			socket.send(respuestaPaquete);
		}
	}
}