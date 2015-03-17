package persistencia

import usuario.*
import empresa.*
import excepciones.ExcepcionYaExisteElUsuario
import grails.transaction.Transactional
import regalo.Regalo

@Transactional

//TODO: Acá falta fijarse que las transacciones finalicen correctamente y en base a eso decidir, como está ahora puede fallar y no avisar nunca
class PersistenciaService {

	def persistir(Usuario unUsuario){
		println Usuario
		println unUsuario.dni
		println unUsuario.class.name
		def usu = Usuario.list()
		def a = usu.findByNombre(unUsuario.nombre)
		def u = usu.findByDni(unUsuario.dni)
		if (usu!=null)
			throw new ExcepcionYaExisteElUsuario("Ese usuario ya existe");
		else
			if(!unUsuario.save(flush:true, failOnError:true))
			println unUsuario.regaloActual.idRegalo
	}

	def obtenerUsuarioPorID(int id){
		Usuario unaPersona = Usuario.get(id)
	}
	
	def eliminarUsuarioPorID(int id){
		def unUsuario = obtenerUsuarioPorID(id)
		unUsuario.delete(flush:true)
	}

	def guardarModificado(Usuario unUsuario){
		unUsuario.save(flush:true)
	}

	def obtenerRegalosHoy(){
		def regalos= Regalo.findAllByFechaRegaladoAndRegalado(new Date().clearTime(),false)
	}

	def obtenerRegaloPorID(int id){
		Regalo unRegalo = Regalo.get(id)
	}

	def obtenerRegalosDelMes(){
		def fecha=new Date()
		def regalos=Regalo.getAll().findAll{it.fechaRegalado.getYear()==fecha.getYear()&&it.fechaRegalado.getMonth()==fecha.getMonth()}
	}
	
	def obtenerTodosLosUsuarios(){
		Usuario.list()
	}
	
	def actualizarRegalo(Regalo unRegalo){
		unRegalo.save(flush:true)		
	}

	def obtenerUsuariosPorEmpresa(idEmpresa){
		def usuarios = Usuario.findAllByEmpresa(idEmpresa)
	}
}