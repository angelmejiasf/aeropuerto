package Aeropuerto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {

	private double horallegada;
	private int diasestancia;
	private Vehiculo v;
	public static ArrayList<Cliente> clientesaparcamiento = new ArrayList<>();

	public Cliente(String dNI, String nombre, String apellidos, int edad, String direccion, String email,
			double horallegada, int diasestancia, Vehiculo v) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		this.horallegada = horallegada;
		this.diasestancia = diasestancia;
		this.v = v;
	}

	public Cliente(ArrayList<Cliente> arrayList) {
		// TODO Auto-generated constructor stub
	}

	public double getHorallegada() {
		return horallegada;
	}

	public void setHorallegada(double horallegada) {
		this.horallegada = horallegada;
	}

	public int getDiasestancia() {
		return diasestancia;
	}

	public void setDiasestancia(int diasestancia) {
		this.diasestancia = diasestancia;
	}

	public Vehiculo getV() {
		return v;
	}

	public void setV(Vehiculo v) {
		this.v = v;
	}

	public static ArrayList<Cliente> getClientesaparcamiento() {
		return clientesaparcamiento;
	}

	public static void setClientesaparcamiento(ArrayList<Cliente> clientesaparcamiento) {
		Cliente.clientesaparcamiento = clientesaparcamiento;
	}

	public void añadirCliente(String NEWdni, String NEWnombre, String NEWapellido, int NEWedad, String NEWdireccion,
			String NEWemail, double NEWhorallegada, int NEWdiasestancia, Vehiculo NEWvehiculo) {

		// Crear un nuevo cliente
		Cliente nuevoCliente = new Cliente(NEWdni, NEWnombre, NEWapellido, NEWedad, NEWdireccion, NEWemail,
				NEWhorallegada, NEWdiasestancia, NEWvehiculo);

		// Agregar el nuevo cliente al ArrayList
		clientesaparcamiento.add(nuevoCliente);
		

	}

	public void leerClientes() {
		System.out.println(clientesaparcamiento);
	}

	public void generarTickets() throws FileNotFoundException {
		DecimalFormat formato = new DecimalFormat("#.##");
		for (Cliente c : this.getClientesaparcamiento()) {
			PrintWriter salida = new PrintWriter(new File("Ticket" + c.getNombre() + c.getApellidos()+ ".txt"));
			salida.println("Cliente: " + c.getNombre()+ " "+ c.getApellidos());
			salida.println("Dias de estancia: " + c.getDiasestancia());

			// Acceder al vehículo del cliente
			Vehiculo vehiculo = c.getV();

			// Inicializar el precio total
			double precioTotal = 0.0;

			// Verificar el tipo de vehículo y obtener el precio
			if (vehiculo instanceof Moto) {
				Moto moto = (Moto) vehiculo;
				precioTotal = moto.getPrecio() * c.getDiasestancia();
			} else if (vehiculo instanceof Furgoneta) {
				Furgoneta furgoneta = (Furgoneta) vehiculo;
				precioTotal = furgoneta.getPrecio() * c.getDiasestancia();
			} else if (vehiculo instanceof Coche) {
				Coche coche = (Coche) vehiculo;
				precioTotal = coche.getPrecio() * c.getDiasestancia();
			}

			// Imprimir el precio total en el ticket
			salida.println("Precio total: " + formato.format(precioTotal));

			salida.flush();
			salida.close();
		}
		
		System.out.println("Tickets generados correctamente");
	}

	@Override
	public String toString() {
		return "Cliente [DNI=" + getDNI() + ", Nombre=" + getNombre() + ", Apellidos=" + getApellidos() + ", Edad="
				+ getEdad() + ", Dirección=" + getDireccion() + ", Email=" + getEmail() + ", Hora de llegada="
				+ horallegada + ", Días de estancia=" + diasestancia + " Vehiculo= " + getV() + " ";
	}

}
