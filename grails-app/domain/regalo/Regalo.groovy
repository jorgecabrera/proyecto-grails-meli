package regalo

import usuario.Usuario

class Regalo {
	
	String url
	Date fechaRegalado
	static belongsTo = [usuario:Usuario]
    
	static constraints = {
    }
}
