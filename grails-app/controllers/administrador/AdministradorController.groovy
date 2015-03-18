package administrador
import grails.plugin.springsecurity.annotation.*
import usuario.*

@Secured(["ROLE_SUPERADMIN"])
class AdministradorController {
	def persistenciaAdminService;
	def persistenciaEmpresaService;
	def index() {
		def administradores = persistenciaAdminService.obtenerAdministradores();
		[administradores:administradores]
	}
	def crearAdministrador(){
		[empresas: persistenciaEmpresaService.obtenerTodasLasEmpresas()]
	}
	def crear(){
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def administradorNuevo = new User(username:'',password:'');
		def unaEmpresa = persistenciaEmpresaService.obtenerEmpresaPorID(params.idEmpresa as int);
		administradorNuevo.username = params.nombre;
		administradorNuevo.password = params.password;
		administradorNuevo.empresa = unaEmpresa;	
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
		def unAdmin = persistenciaAdminService.obtenerAdminPorID(params.id as int);
		unAdmin.username=params.username;
		unAdmin.password=params.password
		persistenciaAdminService.guardarModificado(unAdmin)
		redirect(action: "index");
	}
	def eliminarAdministrador(){
		persistenciaAdminService.eliminarAdminPorID(params.id as int)
		redirect(action: "index")
	}
}
