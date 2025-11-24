package ejercicio03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ReceptorUDP implements Runnable {

	private DatagramSocket socket;
	private String nombre;

	public ReceptorUDP(DatagramSocket socket, String nombre) {
		this.socket = socket;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		try {
			byte[] buffer = new byte[1024];
			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

			while (true) {
				socket.receive(paquete);
				String msg = new String(paquete.getData(), 0, paquete.getLength());
				System.out.println("[" + nombre + "] Recibido: " + msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
