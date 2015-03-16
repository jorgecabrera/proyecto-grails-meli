package administrador
import grails.plugin.springsecurity.annotation.*
import usuario.User

class AdministradorController {
	def persistenciaAdminService;
	
	@Secured(["permitAll"])
	def index() {
		def administradores = persistenciaAdminService.obtenerAdministradores();
		[administradores:administradores]
	}
}
