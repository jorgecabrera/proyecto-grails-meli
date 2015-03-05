package regalo

import usuario.Usuario

class Regalo {

	String url
	Date fechaRegalado
	static belongsTo = [usuario:Usuario]

	static constraints = {
	}

	def Regalo(Date unaFecha){
		Date fechaDeComparacion=new Date()
		fechaDeComparacion.clearTime()
		unaFecha.setYear(fechaDeComparacion.getYear())
		if(unaFecha.before(fechaDeComparacion)){
			unaFecha.setYear(unaFecha.getYear()+1)
			this.fechaRegalado=unaFecha
		}
		else{
	
			this.fechaRegalado=unaFecha}
		this.url="NO HAY REGALO"
	}
}
