package usuario

import regalo.Regalo

class Empleado {
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	Regalo regaloActual

	static hasMany = [historialDeRegalos: Regalo]

	def Empleado(String unNombre,String unApellido, Date unaFechaDeCumpleanios,String unDni,String urlRegalo,String urlImagen,float precioRegalo,String idRegalo){
		nombre=unNombre
		apellido=unApellido
		fechaDeCumpleanios=unaFechaDeCumpleanios
		dni=unDni
		regaloActual=new Regalo(unaFechaDeCumpleanios,urlRegalo,urlImagen,precioRegalo,idRegalo)
		historialDeRegalos=new ArrayList<Regalo>()
	}
}