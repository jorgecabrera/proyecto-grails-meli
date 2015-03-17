package administrador
import grails.plugin.springsecurity.annotation.*
import usuario.*

@Secured(["permitAll"])
class AdministradorController {
	def persistenciaAdminService;
	
	@Secured(["permitAll"])
	def index() {
		def administradores = persistenciaAdminService.obtenerAdministradores();
		[administradores:administradores]
	}
	
	@Secured(["permitAll"])
	def crearAdministrador(){
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def administradorNuevo = new User(username:'',password:'',enabled:'',accountExpired:'',accountLocked:'',passwordExpired:'');
		administradorNuevo.save(flush:true)
		UserRole.create administradorNuevo, adminRole, true;
		[administrador: administradorNuevo];
	}
}
