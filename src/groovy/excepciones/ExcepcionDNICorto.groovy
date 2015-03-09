package excepciones

class ExcepcionDNICorto extends RuntimeException {
	
	public ExcepcionDNICorto(String mensaje) {
		super(mensaje);
	}
}
