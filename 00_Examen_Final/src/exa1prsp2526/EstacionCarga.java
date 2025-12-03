package exa1prsp2526;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstacionCarga {

	private List<Robot> listaEspera;
	private boolean ocupadaRobot = false;
	private int supervisoresRevisando = 0;

	public EstacionCarga() {
		this.listaEspera = new ArrayList<>();
	}

	public synchronized void solicitarLaCarga(int numero, Robot robot) {
		System.out.println("El TurboEnriqueRT00" + numero + " solicita carga");
		listaEspera.add(robot);
		listaEspera.sort(Comparator.comparingInt(Robot::getPrioridad));
	}

	public synchronized void laCarga(int numero, Robot robot) {
		while (!listaEspera.get(0).equals(robot) || ocupadaRobot || supervisoresRevisando > 0) {
			try {
				System.out.println("El TurboEnriqueRT00" + numero + " tienes que esperar");
				wait();
			} catch (InterruptedException e) {
				System.err.println("Detalle de error: " + e.getMessage());
			}
		}
		ocupadaRobot = true;
		System.out.println("El TurboEnriqueRT00" + numero + " entra a carga (prioridad " + robot.getPrioridad() + " )");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Error durante la carga de robot");
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}

	public synchronized void terminarLaCarga(int numero, Robot robot) {
		ocupadaRobot = false;
		listaEspera.remove(robot);
		notifyAll();
		System.out.println("El TurboEnriqueRT00" + numero + " termino la carga");
	}

	public synchronized void solicitarTurnoInspecion(int numero, DataOutputStream salida) {
		while (ocupadaRobot) {
			try {
				System.out.println("El Supervisor" + numero + " tienes que esperar");
				wait();
			} catch (InterruptedException e) {
				System.err.println("Detalle de error: " + e.getMessage());
			}
		}
		supervisoresRevisando++;

		try {
			salida.writeUTF("Supervisor-" + numero + " esta revisando la estacion de carga");
		} catch (IOException e) {
			System.err.println("Detalle de error: " + e.getMessage());
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Error durante la revision de supervisor");
			System.err.println("Detalle de error: " + e.getMessage());
		}
	}

	public synchronized void terminarTurnoInspecion(int numero) {
		supervisoresRevisando--;
		notifyAll();
		System.out.println("Supervisor " + numero + " termina revision");
	}
}
