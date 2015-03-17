package persistencia

import excepciones.*
import grails.transaction.Transactional
import regalo.Regalo
import empresa.Empresa

@Transactional

//TODO: Acá falta fijarse que las transacciones finalicen correctamente y en base a eso decidir, como está ahora puede fallar y no avisar nunca
class PersistenciaEmpresaService {

	def persistir(Empresa unaEmpresa){
		Empresa empresa=null
		empresa= Empresa.findByDni(unEmpresa.dni)
		if (empresa != null)
			throw new ExcepcionYaExisteLaEmpresa("Esta empresa ya existe");
		else
			if(!unaEmpresa.save(flush:true))
			println unaEmpresa.regaloActual.idRegalo
	}

	def obtenerEmpresaPorID(int id){
		Empresa empresa = Empresa.get(id)
	}
	
	def eliminarEmpresaPorID(int id){
		def empresa = obtenerEmpresaPorID(id)
		empresa.delete(flush:true)
	}

	def guardarModificado(Empresa empresa){
		empresa.save(flush:true)
	}

	def obtenerRegalosHoy(int id){
		def regalos= Regalo.findAllByFechaRegaladoAndRegalado(new Date().clearTime(),false)
		regalos.findAll{it.usuario.empresa.id == id}
	}
	
	def obtenerTodasLasEmpresas(){
		Empresa.list()
	}
}