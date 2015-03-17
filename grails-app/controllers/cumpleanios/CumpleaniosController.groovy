package cumpleanios
import grails.plugin.springsecurity.annotation.*
import empresa.*

@Secured(['permitAll'])

class CumpleaniosController {
	def persistenciaEmpresaService;
    def index() { 
		[empresas:Empresa.list()]
	}
	def verCumpleanios(String id){
		println id
		def regalos
		[empresas:Empresa.list(),empresa:id,regalosDeHoy:regalos]
	}
}
