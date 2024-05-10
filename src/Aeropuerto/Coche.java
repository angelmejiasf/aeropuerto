package Aeropuerto;

public class Coche extends Vehiculo {

	private int Npuertas;
	private int precio;

	

	public Coche(String matricula, String color, String marca, String modelo, int npuertas, int precio) {
		super(matricula, color, marca, modelo);
		Npuertas = npuertas;
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getNpuertas() {
		return Npuertas;
	}

	public void setNpuertas(int npuertas) {
		Npuertas = npuertas;
	}

	
	
	@Override
	public String toString() {
		return "Coche [Npuertas=" + Npuertas + ", precio=" + precio + "]";
	}

	public static void main(String[] args) {
		/**
		String matricula="9087-CJS";
		
		Valida valida=new Valida();
		
		if(valida.validaMatricula(matricula)) {
			Coche coche=new Coche(matricula,"rojo","Citroen","Xsara",4);
			
			System.out.println("Coche añadido");
			System.out.println(coche.toString());
		}else {
			System.out.println("La matricula es invalida");
		}
		*/
		
		
	}

}
