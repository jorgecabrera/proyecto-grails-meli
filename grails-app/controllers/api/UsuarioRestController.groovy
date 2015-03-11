package api

import grails.converters.JSON
import usuario.Usuario
import creador.ClaseCreadora
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionVacio
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionYaExisteElUsuario
import excepciones.ExcepcionDNICorto

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
			render status:500, errorMessage
			return
		}
		catch(ExcepcionSoloLetras e){
			errorMessage = "Los campos nombre y apellido solo pueden contener letras"
			render (status:500, text:errorMessage)
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = "El campo DNI solo puede tener números"
			render status:500, errorMessage
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = "El DNI ingresado es demasiado corto, verifiquelo"
			render status:500, errorMessage
			return
		}

		unUsuario.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",json.fechaDeCumpleanios)

		persistenciaService.guardarModificado(unUsuario)
		render unUsuario as JSON
		errorMessage = null
	}

	def save(){
		
		
		def objetoCreador=new ClaseCreadora()
		def errorMessage=null
		def usuarioACrear

		objetoCreador.nombre=params.nombre
		objetoCreador.apellido=params.apellido
		objetoCreador.dni=params.dni
		objetoCreador.urlRegalo=params.regalo
		objetoCreador.urlImagen=params.urlImagen
		objetoCreador.precioRegalo=params.precioRegalo as float

		def un= params.fechaDeCumpleanios_year
		if (params.fechaDeCumpleanios_month.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_month
		else
			un=un+"-"+params.fechaDeCumpleanios_month
		if (params.fechaDeCumpleanios_day.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_day
		else
			un=un+"-"+params.fechaDeCumpleanios_day

		objetoCreador.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",un)

		try {
			validacionService.validarCreacionDelUsuario(objetoCreador)
		}
		catch(ExcepcionVacio e){
			errorMessage = "Ninguno de los campos puede estar vacio"
			render (view: "/usuarios/crearUsuario", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloLetras e){
			errorMessage = "Los campos nombre y apellido solo pueden contener letras"
			render (view: "/usuarios/crearUsuario", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = "El campo DNI solo puede tener numeros"
			render (view: "/usuarios/crearUsuario", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = "El DNI ingresado es demasiado corto, verifiquelo"
			render (view: "/usuarios/crearUsuario", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}

		usuarioACrear=objetoCreador.crearUsuario()

		try{
			persistenciaService.persistir(usuarioACrear)
		}
		catch(ExcepcionYaExisteElUsuario e){
			errorMessage = "El usuario ya existe"
			render (view: "/usuarios/crearUsuario", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		
		
		
		
		
	}

	def edit(int id){

		render persistenciaService.obtenerUsuarioPorID(id) as JSON
	}
}
