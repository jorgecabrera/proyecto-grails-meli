package persistencia

import grails.transaction.Transactional;
import usuario.*;
import empresa.*;

@Transactional
class PersistenciaAdminService {
	def obtenerAdministradores(){
		return User.list()
	}
	def obtenerAdminPorID(int id){
		User unAdministrador = User.get(id)
	}
	def guardarModificado(User unAdmin){
		unAdmin.save(flush:true);
	}
	def eliminarAdminPorID(int id){
		User unAdmin= obtenerAdminPorID(id);
		UserRole.remove(unAdmin, Role.findByAuthority("ROLE_ADMIN"),true)
		unAdmin.delete(flush:true);
	}
}
