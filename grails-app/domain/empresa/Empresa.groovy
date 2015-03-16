package empresa

import usuario.*

class Empresa {
	String cuit
	String nombre
	
	static hasMany = [empleados:Usuario,
						administradores:User]
    static constraints = {
		
    }
}
