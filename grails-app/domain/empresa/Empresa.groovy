package empresa

import usuario.*

class Empresa {
	String cuit
	String nombre
	
	static hasMany = [empleados: Usuario, administradores: User]
    
    static constraints = {
    }
    public Empresa(){
    	cuit=""
    	nombre=""
    	empleados=[]
    	administradores=[]
    }
}
