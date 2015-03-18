package cumpleanios
import grails.plugin.springsecurity.annotation.*
import empresa.*

@Secured(['permitAll'])

class CumpleaniosController {
	def persistenciaEmpresaService;
    def index() { 
		def message="";
		println params.error
		if(params.error=="1"){
			message="No se ha ingresado la empresa, por favor ingrese una"
		}
		[empresas:Empresa.list(),errorMessage:message]
	}
	def verCumpleanios(String id){
		Empresa empresa=persistenciaEmpresaService.obtenerEmpresaPorNombre(id)
		if(empresa == null){
			redirect(controller:"cumpleanios",action:"index",params:[error:1])
			return
		}
		def regalos = persistenciaEmpresaService.obtenerRegalosHoy(empresa.id as int)
		[empresas:Empresa.list(),empresa:id,regalosDeHoy:regalos]
	}
}
