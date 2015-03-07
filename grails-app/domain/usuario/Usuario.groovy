package usuario

import regalo.Regalo

class Usuario {
	
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	Regalo regaloActual
	static hasMany = [historialDeRegalos:Regalo]
	
    static constraints = {
		regaloActual nullable:true
    }
	
	def Usuario(String unNombre,String unApellido, Date unaFechaDeCumpleanios,String unDni,String urlRegalo,String urlImagen,float precioRegalo){
		nombre=unNombre
		apellido=unApellido
		fechaDeCumpleanios=unaFechaDeCumpleanios
		dni=unDni
		regaloActual=new Regalo(unaFechaDeCumpleanios,urlRegalo,urlImagen,precioRegalo)
		historialDeRegalos=new ArrayList<Regalo>()
	}
	
	def confirmarRegaloActual(){
		regaloActual.regalado=true
		historialDeRegalos.add(regaloActual)
		this.regaloActual=new Regalo(fechaDeCumpleanios,"","",0)
		Date unaFecha=new Date()
		unaFecha.setYear(unaFecha.getYear()+1)
		unaFecha.clearTime()
		regaloActual.setFechaRegalado(unaFecha)
	}
}
