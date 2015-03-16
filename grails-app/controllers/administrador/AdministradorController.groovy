package administrador
import grails.plugin.springsecurity.annotation.*

class AdministradorController {
	@Secured(["permitAll"])
    def index() { }
}
