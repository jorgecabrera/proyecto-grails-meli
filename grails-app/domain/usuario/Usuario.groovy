package usuario

import regalo.Regalo

class Usuario {
	
	String nombre
	String apellido
	Date fechaDeCumpleanios
	Regalo regaloActual
	static hasMany = [historialDeRegalos:Regalo]
	
    static constraints = {
    }
}
