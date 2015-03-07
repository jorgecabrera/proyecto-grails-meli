package creador

import usuario.Usuario

class ClaseCreadora {
	
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	String urlRegalo
	String urlImagen
	float precioRegalo
	
	def ClaseCreadora(){
		this.nombre=""
		this.apellido=""
		this.dni=""
		this.fechaDeCumpleanios=new Date()
		this.urlRegalo=""
		this.urlImagen=""
		this.precioRegalo=0;
		
	}
	
	def crearUsuario(){
		new Usuario(nombre,apellido,fechaDeCumpleanios,dni,urlRegalo,urlImagen,precioRegalo)
	}

}
