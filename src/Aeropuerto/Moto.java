package Aeropuerto;

public class Moto extends Vehiculo{

	private String tipo;
	private int cilindrada;
	private String carnet;
	private int precio;
	
	
	public Moto(String matricula, String color, String marca, String modelo, String tipo, int cilindrada, String carnet,
			int precio) {
		super(matricula, color, marca, modelo);
		this.tipo = tipo;
		this.cilindrada = cilindrada;
		this.carnet = carnet;
		this.precio = precio;
	}
	
	
	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	@Override
	public String toString() {
		return "Moto [tipo=" + tipo + ", cilindrada=" + cilindrada + ", carnet=" + carnet + ", precio=" + precio + "]";
	}
	
	
	
	
	
}
