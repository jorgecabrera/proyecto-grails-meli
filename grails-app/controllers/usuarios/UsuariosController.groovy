package usuarios

import creador.ClaseCreadora
import usuario.Usuario
import excepciones.ExcepcionSoloLetras
import excepciones.ExcepcionVacio
import excepciones.ExcepcionSoloNumeros
import excepciones.ExcepcionYaExisteElUsuario

class UsuariosController {

	static scope = "session"
	String errorMessage=null
	def validacionService
	def objetoCreador=new ClaseCreadora()
	def persistenciaService

	def crearUsuario(){
		[objetoCreador:objetoCreador,errorMessage:errorMessage]
	}


	def modificarUsuario(){
	}

	def verUsuarios(){
	}

	def volver(){

		objetoCreador.nombre=""
		objetoCreador.apellido=""
		objetoCreador.dni=""
		objetoCreador.fechaDeCumpleanios=new Date()
		errorMessage = null
		redirect(uri: "/")
	}

	def crear(){

		Usuario usuarioACrear

		objetoCreador.nombre=params.nombre
		objetoCreador.apellido=params.apellido
		objetoCreador.dni=params.dni
		objetoCreador.fechaDeCumpleanios=params.fechaDeCumpleanios

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
			errorMessage = "El campo DNI solo puede tener números"
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
		
		objetoCreador.nombre=""
		objetoCreador.apellido=""
		objetoCreador.dni=""
		objetoCreador.fechaDeCumpleanios=new Date()
		errorMessage = null
		
		redirect(uri: "/")
	}
}
