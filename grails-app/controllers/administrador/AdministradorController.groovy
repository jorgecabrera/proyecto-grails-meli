package administrador
import grails.plugin.springsecurity.annotation.*
import usuario.*

@Secured(["ROLE_SUPERADMIN"])
class AdministradorController {
	def persistenciaAdminService;
	
	def index() {
		def administradores = persistenciaAdminService.obtenerAdministradores();
		[administradores:administradores]
	}
	
	def crearAdministrador(){
	}
	
	def crear(){
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def administradorNuevo = new User(username:'',password:'');
		administradorNuevo.username = params.nombre;
		administradorNuevo.password = params.password;	
		administradorNuevo.save(flush:true);
		UserRole.create administradorNuevo, adminRole, true;
		redirect(uri: "/")
	}
	
	def volver(){
		redirect(uri:"/administrador");
	}
	def mostrarAdministrador(int id) {
		def unAdmin = persistenciaAdminService.obtenerAdminPorID(id);
		[unAdmin:unAdmin]
	}
	def editarAdministrador(){
		def unAdmin = persistenciaAdminService.obtenerAdminPorID(params.id as int)
		[unAdmin:unAdmin]
	}
	def modificarAdministrador(){
		def unAdmin = persistenciaAdminService.obtenerAdminPorID(params.id as int)
		unAdmin.username=params.username
		println params.username
		unAdmin.password=params.password
		println params.password
		persistenciaAdminService.guardarModificado(unAdmin)
		redirect(action: "index")
	}
	
	def eliminarAdministrador(){
		
	}
}
