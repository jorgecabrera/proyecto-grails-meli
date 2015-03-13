package usuario

import regalo.Regalo
import grails.rest.Resource


class Usuario {
	transient springSecurityService

	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	Regalo regaloActual
	static hasMany = [historialDeRegalos:Regalo]
	static transients = ['springSecurityService']
	
    static constraints = {
		regaloActual nullable:true
    }
	
	def Usuario(String unNombre,String unApellido, Date unaFechaDeCumpleanios,String unDni,String urlRegalo,String urlImagen,float precioRegalo,String idRegalo){
		nombre=unNombre
		apellido=unApellido
		fechaDeCumpleanios=unaFechaDeCumpleanios
		dni=unDni
		regaloActual=new Regalo(unaFechaDeCumpleanios,urlRegalo,urlImagen,precioRegalo,idRegalo)
		historialDeRegalos=new ArrayList<Regalo>()
	}
	
	def confirmarRegaloActual(){
		regaloActual.regalado=true
		historialDeRegalos.add(regaloActual)
		this.regaloActual=new Regalo(fechaDeCumpleanios,"","",0,"")
		Date unaFecha=new Date()
		unaFecha.setYear(unaFecha.getYear()+1)
		unaFecha.clearTime()
		regaloActual.setFechaRegalado(unaFecha)
	}
}
