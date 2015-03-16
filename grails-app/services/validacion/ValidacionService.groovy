package validacion

import creador.ClaseCreadora
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionVacio
import excepciones.ExcepcionDNICorto
import grails.transaction.Transactional

@Transactional
class ValidacionService {

	def validarCreacionDelUsuario(def usuario){
		this.validarCamposVacios(usuario)
		this.validarNombreYApellido(usuario)
		this.validarDNI(usuario)
	}

	def validarCamposVacios(def usuario){
		if (usuario.nombre.isEmpty()||usuario.apellido.isEmpty()||usuario.dni.isEmpty())
			throw new ExcepcionVacio("Debe ingresar un texto");
	}
	def validarNombreYApellido(def usuario){
		if (!usuario.nombre.matches("([a-z]|[A-Z]|\\s)+")||!usuario.apellido.matches("([a-z]|[A-Z]|\\s)+"))
			throw new ExcepcionSoloLetras("Solo puede haber letras en los campos nombre y apellido");
	}

	def validarDNI(def usuario){
		def numero
		if(usuario.dni.length()<7){
			throw new ExcepcionDNICorto("El DNI ingresado es muy corto, verifiquelo")
		}
		if(usuario.dni=~/^[0-9]+$/)
			throw new ExcepcionSoloNumeros("Solo puede haber numeros en el campo DNI")
	}

	def validarCamposVaciosEmpresa(def empresa){
		if(empresa.nombre.isEmpty() || empresa.cuit.isEmpty())
			throw new ExcepcionVacio("Debe ingresar un texto")
	}

	def validarCuit(def cuit){
		if(cuit=~/^[0-9]+$/)
			throw new ExcepcionSoloNumeros("Solo puede haber numeros en el cuit")
		if(cuit.length() != 11)
			throw new ExcepcionDNICorto("El Cuit ingresado es muy corto, verifiquelo")
	}

	def validarEmpresa(def empresa){
		this.validarCamposVaciosEmpresa(empresa)
		this.validarCuit(empresa.cuit)
	}
}
