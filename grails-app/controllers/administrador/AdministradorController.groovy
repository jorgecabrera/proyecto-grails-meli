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
	}
	
	@Secured(["permitAll"])
	def crear(){
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def administradorNuevo = new User(username:'',password:'');
		
		administradorNuevo.username = params.nombre;
		administradorNuevo.password = params.password;	
		
		administradorNuevo.save(flush:true);
		UserRole.create administradorNuevo, adminRole, true;
		redirect(uri: "/")
	}
	
	@Secured(["permitAll"])
	def volver(){
		redirect(uri:"/administrador");
	}

	@Secured(["permitAll"])
	def mostrarAdministrador(int id) {
		def unAdmin = persistenciaAdminService.obtenerAdminPorID(id);
		[unAdmin:unAdmin]
	}
}
