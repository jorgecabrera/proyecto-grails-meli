package creador

import usuario.Usuario

class ClaseCreadora {
	
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	
	def ClaseCreadora(){
		this.nombre=""
		this.apellido=""
		this.dni=""
		this.fechaDeCumpleanios=new Date()
	}
	
	def crearUsuario(){
		new Usuario(nombre,apellido,fechaDeCumpleanios,dni)
	}

}
