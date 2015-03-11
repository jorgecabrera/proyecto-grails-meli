package regalo

import usuario.Usuario
import grails.rest.Resource

@Resource(uri= "/regalos")
class Regalo {

	String urlRegalo
	Date fechaRegalado
	String urlImagen
	float precioRegalo
	static belongsTo = [usuario:Usuario]
	Boolean regalado

	static constraints = {
	}
	
	def Regalo(Date unaFecha,String urlRegalo,String urlImagen,float precioRegalo){
		this.definirFechaRegalo(unaFecha)
		if(urlRegalo=="")
		this.urlRegalo="Regalo a asignar"
		else
		this.urlRegalo=urlRegalo
		this.regalado=false
		this.urlImagen=urlImagen
		this.precioRegalo=precioRegalo
	}

	def definirFechaRegalo(Date unaFecha2){
		Date unaFecha=new Date()
		unaFecha.setYear(unaFecha2.getYear())
		unaFecha.setMonth(unaFecha2.getMonth())
		unaFecha.setDate(unaFecha2.getDate())
		unaFecha.clearTime()
		Date fechaDeComparacion=new Date()
		fechaDeComparacion.clearTime()
		unaFecha.setYear(fechaDeComparacion.getYear())
		if(unaFecha.before(fechaDeComparacion)){
			unaFecha.setYear(unaFecha.getYear()+1)
			this.fechaRegalado=unaFecha
		}
		else{
			this.fechaRegalado=unaFecha
		}
	}
}
