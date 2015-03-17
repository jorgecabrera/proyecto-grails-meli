package empresa

import excepciones.*
import creador.ClaseCreadoraEmpresa

class EmpresaController {

    def index() {
    	[empresas:Empresa.list()]
    }

    def verCumples(empresa){

    }

	def crearEmpresa(){

		def errorMessage=null
		def objetoCreador=new ClaseCreadoraEmpresa()

		[objetoCreador:objetoCreador,errorMessage:errorMessage]
	}

	def verEmpresas(){
		[empresas:persistenciaEmpresaService.obtenerTodasLasEmpresas()]
	}

	def mostrarEmpresa(int id) {

		def empresa = persistenciaEmpresaService.obtenerEmpresaPorID(id)

		[unaEmpresa:unaEmpresa]
	}

	def ok() {
		redirect(action: "verEmpresas")
	}

	def volver(){
		redirect(uri: "/")
	}

	def crear(){

		def objetoCreador=new ClaseCreadoraEmpresa()
		def errorMessage=null
		def empresaACrear

		objetoCreador.nombre = params.nombre
		objetoCreador.cuit = params.cuit

		try {
			validacionService.validarCreacionDeLaEmpresa(objetoCreador)
		}
		catch(ExcepcionVacio e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}

		empresaACrear=objetoCreador.crearEmpresa()

		try{
			persistenciaEmpresaService.persistir(empresaACrear)
		}
		catch(ExcepcionYaExisteLaEmpresa e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}

		redirect(uri: "/")
	}

	def editarEmpresa(){

		def unaEmpresa = persistenciaEmpresaService.obtenerEmpresaPorID(params.id as int)

		[unaEmpresa:unaEmpresa]
	}

	def eliminar(){
		persistenciaEmpresaService.eliminarEmpresaPorID(params.id as int)
		redirect(action: "verEmpresas")
	}

	def modificar(){

		def errorMessage=null
		def unaEmpresa = persistenciaEmpresaService.obtenerEmpresaPorID(params.id as int)

		unaEmpresa.nombre=params.nombre
		unaEmpresa.cuit=params.cuit

		try {
			validacionService.validarCreacionDeLaEmpresa(objetoCreador)
		}
		catch(ExcepcionVacio e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionSoloNumeros e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}
		catch(ExcepcionDNICorto e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}

		empresaACrear=objetoCreador.crearEmpresa()

		try{
			persistenciaEmpresaService.persistir(empresaACrear)
		}
		catch(ExcepcionYaExisteLaEmpresa e){
			errorMessage = e.message
			render (view: "/empresa/crearEmpresa", model: [objetoCreador:objetoCreador,errorMessage:errorMessage])
			return
		}

		errorMessage = null
		redirect(action: "verEmpresas")
	}
}