package Aeropuerto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Gimnasio.ActividadReservada;

public class Conductor extends Persona {

	private int Codigo;
	private int Turno;
	public ArrayList<Conductor> conductor;

	public Conductor(int codigo, int turno, String dNI, String nombre, String apellidos, int edad, String direccion,
			String email) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		Codigo = codigo;
		Turno = turno;

	}

	public Conductor(ArrayList<Conductor> arrayList) {
		this.conductor = new ArrayList<>(arrayList);
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public int getTurno() {
		return Turno;
	}

	public void setTurno(int turno) {
		Turno = turno;
	}

	@Override

	public String toString() {
		return "El conductor con codigo " + Codigo + " tiene de turno numero " + Turno + " su DNI es " + getDNI()
				+ " con nombre " + getNombre() + " " + getApellidos() + " su edad es de " + getEdad()
				+ " años y vive en " + getDireccion();
	}

	public void cargaConductores(String filename) {
		conductor = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			// En caso de que queramos saltar la primera linea
			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");

				conductor.add(new Conductor(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]), linea[2], linea[3],
						linea[4], Integer.parseInt(linea[5]), linea[6], linea[7]));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void leerConductores() {
		System.out.println(conductor);
	}

	public void imprimirTurnoDeEntrega(ArrayList<Conductor> conductores) {
		// Definir los horarios de los turnos
		int[][] horarios = { { 8, 15 }, { 16, 24 }, { 1, 8 } };

		// Iterar sobre la lista de conductores
		for (Conductor conductor : conductores) {
			// Obtener el turno del conductor
			int turnoConductor = conductor.getTurno();

			// Verificar si el turno del conductor es válido
			if (turnoConductor > 0 && turnoConductor <= horarios.length) {
				// Obtener los horarios de inicio y fin del turno
				int horaInicio = horarios[turnoConductor - 1][0];
				int horaFin = horarios[turnoConductor - 1][1];

				// Imprimir el turno del conductor
				System.out.println("Turno del conductor " + conductor.getNombre() + ": " + horaInicio + " - " + horaFin
						+ " horas");

				// Iterar sobre la lista de clientes
				for (Cliente cliente : Cliente.clientesaparcamiento) {
					// Verificar si la hora de llegada del cliente coincide con el turno del
					// conductor
					double horaLlegadaCliente = cliente.getHorallegada();
					if ((horaLlegadaCliente >= horaInicio && horaLlegadaCliente <= horaFin) || (horaInicio > horaFin
							&& (horaLlegadaCliente >= horaInicio || horaLlegadaCliente <= horaFin))) {
						// Imprimir los datos del cliente junto con los datos del vehículo del cliente
						System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());
						System.out.println("Vehículo: Matrícula=" + cliente.getV().getMatricula() + ", Marca="
								+ cliente.getV().getMarca() + ", Modelo=" + cliente.getV().getModelo());
						System.out.println(); // Salto de línea entre clientes
					}
				}
				System.out.println(); // Salto de línea entre conductores
			} else {
				System.out.println("El turno del conductor " + conductor.getNombre() + " es inválido.");
			}
		}
	}

}
