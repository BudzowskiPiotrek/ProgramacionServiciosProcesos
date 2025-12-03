package exa1prsp2526;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Supervisor implements Runnable {
	private String host = "localhost";
	private int puerto = 5000;
	private DataOutputStream salida;
	private EstacionCarga ec;
	private int numero;

	public Supervisor(int numero, EstacionCarga ec) {
		this.numero = numero;
		this.ec = ec;

		try {
			Socket cliente = new Socket(host, puerto);
			System.out.println("Servidor conectado con el Servidor");
			salida = new DataOutputStream(cliente.getOutputStream());
		} catch (UnknownHostException e) {
			System.err.println("Error al ingresar la ip");
			System.err.println("Detalle de error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al intentar inicializar la conexion");
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			ec.solicitarTurnoInspecion(numero, salida);
			ec.terminarTurnoInspecion(numero);
			try {
				salida.writeUTF("Supervisor-" + numero + " ha finalizado la revision de la estacion de carga");
			} catch (IOException e) {
				System.err.println("Error en intento de mandar mensaje......");
				System.err.println("Detalle de error: " + e.getMessage());
			}
		}
	}
}
