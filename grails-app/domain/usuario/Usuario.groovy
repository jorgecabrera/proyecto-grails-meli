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
	
	def Usuario(String unNombre,String unApellido, Date unaFechaDeCumpleanios,String unDni){
		nombre=unNombre
		apellido=unApellido
		fechaDeCumpleanios=unaFechaDeCumpleanios
		dni=unDni
		regaloActual=null
		historialDeRegalos=new ArrayList<Regalo>()
	}
}
