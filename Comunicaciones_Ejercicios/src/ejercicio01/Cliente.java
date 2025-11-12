package ejercicio01;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {

	private static final int PUERTO = 5000;
	Socket cliente;
	String mensaje;
	DataOutputStream salida;

	public void initClient() {
		try {
			cliente = new Socket("LocalHost", PUERTO);
			System.out.println("Write....");
			Scanner sn = new Scanner(System.in);
			mensaje = sn.nextLine();
			salida = new DataOutputStream(cliente.getOutputStream());
			salida.writeUTF(mensaje);
			System.out.println("Mensage send");
			salida.close();
			cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.initClient();
	}

}
