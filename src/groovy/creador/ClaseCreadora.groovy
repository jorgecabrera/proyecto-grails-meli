package creador

import usuario.Usuario

class ClaseCreadora {
	
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	String urlRegalo
	
	def ClaseCreadora(){
		this.nombre=""
		this.apellido=""
		this.dni=""
		this.fechaDeCumpleanios=new Date()
		this.urlRegalo=""
		
	}
	
	def crearUsuario(){
		new Usuario(nombre,apellido,fechaDeCumpleanios,dni,urlRegalo)
	}

}
