package ejercicio01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HiloServidorMulti extends Thread {
	public static List<Socket> lista = new ArrayList<>();
	DataInputStream fEntrada;
	DataOutputStream fSalida;
	Socket socket = null;

	public HiloServidorMulti(Socket cliente) {
		this.socket = cliente;
		try {
			synchronized (lista) {
				this.lista.add(cliente);
			}
			this.fSalida = new DataOutputStream(socket.getOutputStream());
			this.fEntrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("comunicado con :" + socket.toString());
		String mensaje = "";

		while (true) {
			try {
				mensaje = fEntrada.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Recibido de " + socket + ": " + mensaje);

			if (mensaje.trim().equals("*")) {
				break;
			}
			enviarATodos(mensaje);
		}
		System.out.println("pin con: " + socket.toString());
		try {
			fSalida.close();
			fEntrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void enviarATodos(String mensaje) {
		synchronized (lista) {
			for (Socket s : lista) {
				try {
					DataOutputStream fsalida = new DataOutputStream(s.getOutputStream());
					fsalida.writeUTF(socket.getInetAddress() + "] : " + mensaje);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
