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
}
