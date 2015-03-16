package creador

import empresa.Empresa

class ClaseCreadoraEmpresa {
	
	String nombre
	String cuit
	
	def ClaseCreadoraEmpresa(){
		this.nombre = ""
		this.cuit = ""
	}
	
	def crearEmpresa(){
		new Empresa(nombre: this.nombre, cuit: this.cuit)
	}

}
