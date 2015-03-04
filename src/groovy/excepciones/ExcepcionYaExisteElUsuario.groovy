package excepciones

class ExcepcionYaExisteElUsuario extends RuntimeException {
	
	public ExcepcionYaExisteElUsuario(String mensaje) {
		super(mensaje);
	}
}
