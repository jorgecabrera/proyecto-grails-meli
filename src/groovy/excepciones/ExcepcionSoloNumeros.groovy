package excepciones

class ExcepcionSoloNumeros extends RuntimeException {
	
	public ExcepcionSoloNumeros(String mensaje) {
		super(mensaje);
	}
}