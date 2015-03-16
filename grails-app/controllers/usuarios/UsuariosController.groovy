package usuarios

import creador.ClaseCreadora
import regalo.Regalo
import usuario.Usuario
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionVacio
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionYaExisteElUsuario
import excepciones.ExcepcionDNICorto
import grails.plugin.springsecurity.annotation.*

@Secured(['ROLE_ADMIN'])
class UsuariosController {


	def validacionService
	def persistenciaService

	@Secured(["permitAll"])
	def index(){

		def regalosDeHoy=persistenciaService.obtenerRegalosHoy()

		[regalosDeHoy:regalosDeHoy]
	}

	def crearUsuario(){

		def errorMessage=null
		def objetoCreador=new ClaseCreadora()

		[objetoCreador:objetoCreador,errorMessage:errorMessage]
	}

	def verUsuarios(){
		[usuarios:persistenciaService.obtenerTodosLosUsuarios()]
	}

	def mostrarUsuario(int id) {

		def unUsuario = persistenciaService.obtenerUsuarioPorID(id)

		[unUsuario:unUsuario]
	}

	def ok() {
		redirect(action: "verUsuarios")
	}

	def volver(){
		redirect(uri: "/")
	}

	def crear(){

		def objetoCreador=new ClaseCreadora()
		def errorMessage=null
		def usuarioACrear

		objetoCreador.nombre=params.nombre
		objetoCreador.apellido=params.apellido
		objetoCreador.dni=params.dni
		objetoCreador.urlRegalo=params.regalo
		objetoCreador.urlImagen=params.urlImagen
		objetoCreador.precioRegalo=params.precioRegalo as float
		objetoCreador.idRegalo=params.idRegalo

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

		redirect(uri: "/")
	}

	def editarUsuario(){

		def unUsuario = persistenciaService.obtenerUsuarioPorID(params.id as int)

		[unUsuario:unUsuario]
	}

	def eliminar(){
		persistenciaService.eliminarUsuarioPorID(params.id as int)
		redirect(action: "verUsuarios")
	}

	def modificar(){

		def errorMessage=null
		def unUsuario = persistenciaService.obtenerUsuarioPorID(params.id as int)

		unUsuario.nombre=params.nombre
		unUsuario.apellido=params.apellido
		unUsuario.dni=params.dni

		def un= params.fechaDeCumpleanios_year
		if (params.fechaDeCumpleanios_month.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_month
		else
			un=un+"-"+params.fechaDeCumpleanios_month
		if (params.fechaDeCumpleanios_day.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_day
		else
			un=un+"-"+params.fechaDeCumpleanios_day

		unUsuario.regaloActual.urlRegalo=params.regalo
		unUsuario.regaloActual.urlImagen=params.urlImagen
		unUsuario.regaloActual.precioRegalo=params.precioRegalo as float
		unUsuario.regaloActual.idRegalo=params.idRegalo

		try {
			validacionService.validarCreacionDelUsuario(unUsuario)
		}
		catch(ExcepcionVacio e){
			errorMessage = "Ninguno de los campos puede estar vacio"
			render (view: "/usuarios/editarUsuario", model: [unUsuario:unUsuario,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloLetras e){
			errorMessage = "Los campos nombre y apellido solo pueden contener letras"
			render (view: "/usuarios/editarUsuario", model: [unUsuario:unUsuario,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = "El campo DNI solo puede tener números"
			render (view: "/usuarios/editarUsuario", model: [unUsuario:unUsuario,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = "El DNI ingresado es demasiado corto, verifiquelo"
			render (view: "/usuarios/crearUsuario", model: [unUsuario:unUsuario,errorMessage:errorMessage])
			return
		}

		if(unUsuario.fechaDeCumpleanios.compareTo(new Date().parse("yyyy-MM-dd",un))){
			unUsuario.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",un)
			unUsuario.getRegaloActual().definirFechaRegalo(unUsuario.getFechaDeCumpleanios())
		}

		try{
			persistenciaService.guardarModificado(unUsuario)
		}
		catch(ExcepcionYaExisteElUsuario e){
			errorMessage = "El usuario ya existe"
			render (view: "/usuarios/editarUsuario", model: [unUsuario:unUsuario,errorMessage:errorMessage])
			return
		}

		errorMessage = null
		redirect(action: "verUsuarios")
	}

	def regalar(int id){

		def unRegalo = persistenciaService.obtenerRegaloPorID(id)

		[unRegalo:unRegalo]
	}

	def confirmarRegalo(){

		def unUsuario = persistenciaService.obtenerUsuarioPorID(params.id as int)

		unUsuario.confirmarRegaloActual()
		persistenciaService.guardarModificado(unUsuario)
		redirect(action: "index")
	}
}
