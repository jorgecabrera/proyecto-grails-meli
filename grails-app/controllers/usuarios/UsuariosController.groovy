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
	
	def index(){        
	}

	def crearUsuario(){
		[objetoCreador:objetoCreador,errorMessage:errorMessage]
	}

	def verUsuarios(){

		[usuarios:Usuario.list()]
	}

	def mostrarUsuario(int id) {
		Usuario unUsuario = persistenciaService.obtenerUsuarioPorID(id)
		[unUsuario:unUsuario]
	}

	def ok() {
		redirect(action: "verUsuarios")
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

		String un= params.fechaDeCumpleanios_year
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
	
	def editarUsuario(){
		Usuario unUsuario = persistenciaService.obtenerUsuarioPorID(params.id as int)
		[unUsuario:unUsuario]
	}
	
	def modificar(){
		Usuario unUsuario = persistenciaService.obtenerUsuarioPorID(params.id as int)
		unUsuario.nombre=params.nombre
		unUsuario.apellido=params.apellido
		unUsuario.dni=params.dni
		
		String un= params.fechaDeCumpleanios_year
		if (params.fechaDeCumpleanios_month.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_month
		else
			un=un+"-"+params.fechaDeCumpleanios_month
		if (params.fechaDeCumpleanios_day.length()==1)
			un=un+"-0"+params.fechaDeCumpleanios_day
		else
			un=un+"-"+params.fechaDeCumpleanios_day

		unUsuario.fechaDeCumpleanios= new Date().parse("yyyy-MM-dd",un)

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
	
	
}
