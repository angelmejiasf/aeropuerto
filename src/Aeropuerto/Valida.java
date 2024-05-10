package Aeropuerto;

public class Valida {

	public boolean validaMatricula(String cadena) {
		return cadena.matches("\\d{4}-[A-Z]{3}");
		
	}
	
	public boolean validaDNI(String cadena) {
		return cadena.matches("\\d{8}[A-Za-z]");
		
	}
}
