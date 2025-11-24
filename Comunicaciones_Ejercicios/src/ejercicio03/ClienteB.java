package ejercicio03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteB {
	public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(6000); 
        InetAddress ip = InetAddress.getByName("localhost");

        Thread receptor = new Thread(new ReceptorUDP(socket, "B"));
        receptor.start();

        Scanner br = new Scanner(System.in);
        String texto;

        System.out.println("Cliente A listo. Escribe para enviar a A:");

        while (true) {
            texto = br.nextLine();
            byte[] datos = texto.getBytes();
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, ip, 4000);
            socket.send(paquete);
        }
    }
}
