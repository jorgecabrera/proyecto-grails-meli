package cumpleanios
import grails.plugin.springsecurity.annotation.*
import empresa.*

@Secured(['permitAll'])

class CumpleaniosController {

    def index() { 
		[empresas:Empresa.list()]
	}
}
