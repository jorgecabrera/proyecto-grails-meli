package excepciones

class ExcepcionYaExisteLaEmpresa extends RuntimeException {
	
	public ExcepcionYaExisteLaEmpresa(String mensaje) {
		super(mensaje);
	}
}
