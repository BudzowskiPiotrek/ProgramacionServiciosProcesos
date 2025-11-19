package nue_ejercicio02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RecibirHilo extends Thread {

	DataInputStream fEntrada;

	public RecibirHilo(DataInputStream fEntrada) {
		this.fEntrada = fEntrada;
	}

	public void run() {
		try {
			while (true) {
				String respuesta = fEntrada.readUTF();
				System.out.println(respuesta);
			}
		} catch (IOException e) {
			
		}
	}
}
