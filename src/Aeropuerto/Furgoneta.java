package Aeropuerto;

public class Furgoneta extends Vehiculo {

	private int Capacidad;
	private int precio;

	public Furgoneta(String matricula, String color, String marca, String modelo, int capacidad, int precio) {
		super(matricula, color, marca, modelo);
		Capacidad = capacidad;
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Furgoneta [Capacidad=" + Capacidad + ", precio=" + precio + "]";
	}

	

}
