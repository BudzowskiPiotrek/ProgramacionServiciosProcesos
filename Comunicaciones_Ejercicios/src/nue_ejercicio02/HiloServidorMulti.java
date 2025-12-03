package nue_ejercicio02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HiloServidorMulti extends Thread {
	public static List<Socket> lista = new ArrayList<>();
	DataInputStream fEntrada;
	DataOutputStream fSalida;
	Socket socket = null;
	int idJugador;

	public HiloServidorMulti(Socket cliente, int id) {
		this.socket = cliente;
		this.idJugador = id;
		try {
			synchronized (lista) {
				this.lista.add(cliente);
			}
			this.fSalida = new DataOutputStream(socket.getOutputStream());
			this.fEntrada = new DataInputStream(socket.getInputStream());

			fSalida.writeUTF("Adivina un numero de 1 a 100");
			fSalida.writeUTF("Eres el jugador " + idJugador);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("Jugador conectado: " + idJugador);
		String mensaje = "";

		while (!ServidorMulti.terminado) {
			try {
				mensaje = fEntrada.readUTF();
			} catch (IOException e) {
				break;
			}

			if (idJugador != ServidorMulti.turno) {
				enviarIndividual("Estate quieto, no es tu turno!");
				continue;
			}

			int intento;
			try {
				intento = Integer.parseInt(mensaje.trim());
			} catch (NumberFormatException e) {
				enviarIndividual("Debes enviar un número.");
				continue;
			}

			if (intento == ServidorMulti.numeroSecreto) {
				enviarATodos("Jugador " + idJugador + " gano, era: " + ServidorMulti.numeroSecreto);
				ServidorMulti.terminado = true;
			} else {
				enviarATodos("Jugador " + idJugador + " no ha acertado");
				ServidorMulti.turno++;
				if (ServidorMulti.turno == 4)
					ServidorMulti.turno = 1;
				enviarATodos("Turno del jugador " + ServidorMulti.turno);
				
			}

		}
		cerrar();
	}

	private void enviarIndividual(String s) {
		try {
			fSalida.writeUTF(s);
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

	private void cerrar() {
		try {
			fSalida.close();
			fEntrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
