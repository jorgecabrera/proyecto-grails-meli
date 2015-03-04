package excepciones

class ExcepcionSoloLetras extends RuntimeException {
	
	public ExcepcionSoloLetras(String mensaje) {
		super(mensaje);
	}
}
