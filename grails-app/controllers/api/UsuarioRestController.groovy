package api

import grails.converters.JSON
import usuario.Usuario
import creador.ClaseCreadora
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionVacio
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionYaExisteElUsuario
import excepciones.ExcepcionDNICorto
import java.text.ParseException;

class UsuarioRestController {

	def validacionService
	def persistenciaService

	def index() {
		render persistenciaService.obtenerTodosLosUsuarios() as JSON
	}

	def delete(int id){

		persistenciaService.eliminarUsuarioPorID(id)

		render("oki")
	}

	def update(int id){

		def errorMessage=null
		def unUsuario = persistenciaService.obtenerUsuarioPorID(id)
		def json=request.JSON
		unUsuario.nombre=json.nombre
		unUsuario.apellido=json.apellido
		unUsuario.dni=json.dni

		try {
			validacionService.validarCreacionDelUsuario(unUsuario)
		}
		catch(ExcepcionVacio e){
			errorMessage = "Ninguno de los campos puede estar vacio"
			render (status:500, errorMessage)
			return
		}
		catch(ExcepcionSoloLetras e){
			errorMessage = "Los campos nombre y apellido solo pueden contener letras"
			render (status:500, text:errorMessage)
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = "El campo DNI solo puede tener números"
			render (status:500, text:errorMessage)
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = "El DNI ingresado es demasiado corto, verifiquelo"
			render (status:500,text:errorMessage)
			return
		}

		try{
			unUsuario.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",json.fechaDeCumpleanios)
		}
		catch(ParseException e){
			errorMessage = "La fecha debe tener el formato AAAA-MM-DD"
			render (status:500,text:errorMessage)
			return
		}

		persistenciaService.guardarModificado(unUsuario)
		render unUsuario as JSON
		errorMessage = null
	}

	def save(){


		def objetoCreador=new ClaseCreadora()
		def errorMessage=null
		def usuarioACrear

		def json=request.JSON

		objetoCreador.nombre=json.nombre
		objetoCreador.apellido=json.apellido
		objetoCreador.dni=json.dni

		try{
			objetoCreador.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",json.fechaDeCumpleanios)
		}
		catch(ParseException e){
			errorMessage = "La fecha debe tener el formato AAAA-MM-DD"
			render (status:500,text:errorMessage)
			return
		}
		try {
			validacionService.validarCreacionDelUsuario(objetoCreador)
		}
		catch(ExcepcionVacio e){
			errorMessage = "Ninguno de los campos puede estar vacio"
			render (status:500,text:errorMessage)
			return
		}
		catch(ExcepcionSoloLetras e){
			errorMessage = "Los campos nombre y apellido solo pueden contener letras"
			render (status:500,text:errorMessage)
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = "El campo DNI solo puede tener numeros"
			render (status:500,text:errorMessage)
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = "El DNI ingresado es demasiado corto, verifiquelo"
			render (status:500,text:errorMessage)
			return
		}

		usuarioACrear=objetoCreador.crearUsuario()

		try{
			persistenciaService.persistir(usuarioACrear)
		}
		catch(ExcepcionYaExisteElUsuario e){
			errorMessage = "El usuario ya existe"
			render (status:500,text:errorMessage)
			return
		}


		render(usuarioACrear as JSON)
	}

	def edit(int id){

		render persistenciaService.obtenerUsuarioPorID(id) as JSON
	}
}
