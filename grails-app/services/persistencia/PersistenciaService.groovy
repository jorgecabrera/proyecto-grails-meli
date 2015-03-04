package persistencia

import excepciones.ExcepcionYaExisteElUsuario
import grails.transaction.Transactional
import usuario.Usuario

@Transactional
class PersistenciaService {

	def persistir(Usuario unUsuario){
		Usuario unaPersona=null
		unaPersona= Usuario.findByDni(unUsuario.dni)
		if (unaPersona != null)
			throw new ExcepcionYaExisteElUsuario("Ese usuario ya existe");
		else
			unUsuario.save(flush:true)
	}
}