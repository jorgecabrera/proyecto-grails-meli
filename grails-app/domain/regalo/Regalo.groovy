package regalo

import usuario.Usuario

class Regalo {

	String urlRegalo
	Date fechaRegalado
	static belongsTo = [usuario:Usuario]
	Boolean regalado

	static constraints = {
	}
	
	def Regalo(Date unaFecha,String urlRegalo){
		this.definirFechaRegalo(unaFecha)
		if(urlRegalo=="")
		this.urlRegalo="Regalo a asignar"
		else
		this.urlRegalo=urlRegalo
		this.regalado=false
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
