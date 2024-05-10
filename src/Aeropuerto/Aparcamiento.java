package Aeropuerto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

;

public class Aparcamiento {

	public static void main(String[] args) throws FileNotFoundException {
		int op = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---BIENVENIDOS AL AEROPUERTO---");
			System.out.println("1)Leer Conductores");
			System.out.println("2)Dar de alta cliente");
			System.out.println("3)Guardar Cliente");
			System.out.println("4)Leer clientes");
			System.out.println("5)Generar Tickets");
			System.out.println("6)Imprimir turno de entrega");
			System.out.println("-SELECCIONA UNA OPCION-");
			op = sc.nextInt();

			switch (op) {
			case 1:
				Conductor conductor = new Conductor(new ArrayList<Conductor>());
				conductor.cargaConductores("conductor.csv");
				conductor.leerConductores();
				break;

			case 2:
				System.out.println("Introduce tu DNI: ");
				String NEWdni = sc.next();
				Valida valida = new Valida();
				if (valida.validaDNI(NEWdni)) {
					System.out.println("Introduce tu nombre: ");
					String NEWnombre = sc.next();
					System.out.println("Introduce tu apellido :");
					String NEWapellido = sc.next();
					System.out.println("Introduce tu edad: ");
					int NEWedad = sc.nextInt();
					System.out.println("Introduce tu direccion: ");
					String NEWdireccion = sc.next();
					System.out.println("Introduce tu email : ");
					String NEWemail = sc.next();
					System.out.println("Introduce una hora de llegada :");
					double NEWhorallegada = sc.nextDouble();
					if (NEWhorallegada > 24 || NEWhorallegada < 1) {
						System.out.println("Error al seleccionar la hora");
					} else {
						System.out.println("Introduce los dias de estancia: ");
						int NEWdiasestancia = sc.nextInt();
						System.out.println("Introduce la matrícula del vehículo:");
						String matricula = sc.next();
						if (valida.validaMatricula(matricula)) {
							System.out.println("Introduce el color del vehículo:");
							String color = sc.next();
							System.out.println("Introduce la marca del vehículo:");
							String marca = sc.next();
							System.out.println("Introduce el modelo del vehículo:");
							String modelo = sc.next();
							System.out.println("¿Que tipo de vehiculo es?: ");
							String tipo = sc.next();

							Vehiculo NEWvehiculo = null;
							if (tipo.equals("coche")) {
								System.out.println("Introduce el numero de puertas: ");
								int numpuertas = sc.nextInt();
								int precio = 10;
								Coche coche = new Coche(matricula, color, marca, modelo, numpuertas, precio);
								NEWvehiculo = coche;
							} else if (tipo.equals("moto")) {
								System.out.println("Introduce el tipo: ");
								String tipomoto = sc.next();
								System.out.println("Introduce la cilindrada: ");
								int cilindrada = sc.nextInt();
								System.out.println("Introduce el carnet: ");
								String carnet = sc.next();
								int precio = 5;
								Moto moto = new Moto(matricula, color, marca, modelo, tipomoto, cilindrada, carnet,
										precio);
								NEWvehiculo = moto;
							} else if (tipo.equals("furgoneta")) {
								System.out.println("Introduce la capacidad: ");
								int capacidad = sc.nextInt();
								int precio = 15;
								Furgoneta furgoneta = new Furgoneta(matricula, color, marca, modelo, capacidad, precio);
								NEWvehiculo = furgoneta;
							}

							Cliente cliente = new Cliente(new ArrayList<Cliente>());

							cliente.añadirCliente(NEWdni, NEWnombre, NEWapellido, NEWedad, NEWdireccion, NEWemail,
									NEWhorallegada, NEWdiasestancia, NEWvehiculo);

							System.out.println("CLIENTE GUARDADO");

						} else {
							System.out.println("El formato de la matricula es erroneo");
						}

					}

				} else {
					System.out.println("El DNI esta en un formato erroneo");
				}
				break;

			case 3:
				try {
					FileOutputStream fichero = new FileOutputStream("clientes.par");
					ObjectOutputStream salida = new ObjectOutputStream(fichero);

					if (!Cliente.clientesaparcamiento.isEmpty()) {
						salida.writeObject(Cliente.clientesaparcamiento);
						System.out.println("Clientes guardados en clientes.par");
					} else {
						System.out.println("No hay clientes para guardar");
					}

					salida.close();
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				try {
					FileInputStream fichero = new FileInputStream("clientes.par");
					ObjectInputStream entrada = new ObjectInputStream(fichero);

					ArrayList<Cliente> clientesGuardados = (ArrayList<Cliente>) entrada.readObject();
					System.out.println("Clientes cargados desde clientes.par:");
					System.out.println(clientesGuardados);

					entrada.close();
					fichero.close();
				} catch (IOException | ClassNotFoundException e) {
					System.out.println("No hay clientes para mostrar");
				}
				break;

			case 5:
				Cliente cliente = new Cliente(new ArrayList<Cliente>());
				cliente.generarTickets();
				break;

			case 6:

				Conductor conductor1 = new Conductor(new ArrayList<Conductor>());
				conductor1.cargaConductores("conductor.csv");

				// Llamar al método imprimirTurnoDeEntrega pasando la lista de conductores como
				// argumento
				conductor1.imprimirTurnoDeEntrega(conductor1.conductor);
				break;

			}

		} while (true);

	}
}
