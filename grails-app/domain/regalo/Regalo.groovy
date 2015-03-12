package regalo

import usuario.Usuario
import grails.rest.Resource
import groovy.json.JsonSlurper


class Regalo {

	String urlRegalo
	Date fechaRegalado
	String urlImagen
	float precioRegalo
	static belongsTo = [usuario:Usuario]
	Boolean regalado
	String idRegalo

	static constraints = { idRegalo nullable:true }

	def Regalo(Date unaFecha,String urlRegalo,String urlImagen,float precioRegalo,String idRegalo){
		this.definirFechaRegalo(unaFecha)
		if(urlRegalo=="")
			this.urlRegalo="Regalo a asignar"
		else
			this.urlRegalo=urlRegalo
		this.regalado=false
		this.urlImagen=urlImagen
		this.precioRegalo=precioRegalo
		this.idRegalo=idRegalo
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

	def actualizarPrecio(){
		def url=new URL("https://api.mercadolibre.com/items/"+this.idRegalo);
		def stringdejson=url.getText(requestProperties: [Accept: 'application/json'])
		def slurper = new JsonSlurper()
		def result = slurper.parseText(stringdejson)
		this.precioRegalo=result.price
	}
}
