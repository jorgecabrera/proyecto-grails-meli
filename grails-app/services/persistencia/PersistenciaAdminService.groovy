package persistencia

import grails.transaction.Transactional;
import usuario.User;

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
		User unAdmin= User.get(id);
		unAdmin.delete(flush:true);
	}
}
