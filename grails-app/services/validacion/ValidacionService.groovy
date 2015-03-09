package validacion

import creador.ClaseCreadora
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionVacio
import excepciones.ExcepcionDNICorto
import grails.transaction.Transactional

@Transactional
class ValidacionService {

	def validarCreacionDelUsuario(def unObjetoCreador){
		this.validarCamposVacios(unObjetoCreador)
		this.validarNombreYApellido(unObjetoCreador)
		this.validarDNI(unObjetoCreador)
	}

	def validarCamposVacios(def unObjetoCreador){
		if (unObjetoCreador.nombre.isEmpty()||unObjetoCreador.apellido.isEmpty()||unObjetoCreador.dni.isEmpty())
			throw new ExcepcionVacio("Debe ingresar un texto");
	}
	def validarNombreYApellido(def unObjetoCreador){
		if (!unObjetoCreador.nombre.matches("([a-z]|[A-Z]|\\s)+")||!unObjetoCreador.apellido.matches("([a-z]|[A-Z]|\\s)+"))
			throw new ExcepcionSoloLetras("Solo puede haber letras en los campos nombre y apellido");
	}

	def validarDNI(def unObjetoCreador){
		def numero
		if(unObjetoCreador.dni.length()<7){
			throw new ExcepcionDNICorto("El DNI ingresado es muy corto, verifiquelo")
		}
		try {
			numero=Integer.parseInt(unObjetoCreador.dni)
		}
		catch (NumberFormatException e){
			throw new ExcepcionSoloNumeros("Solo puede haber numeros en el campo edad")
		}
	}
}
