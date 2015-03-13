package usuario

import regalo.Regalo

class Usuario {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	//Extras
	String nombre
	String apellido
	String dni
	Date fechaDeCumpleanios
	Regalo regaloActual

	static hasMany = [historialDeRegalos: Regalo]

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	def Usuario(String unNombre,String unApellido, Date unaFechaDeCumpleanios,String unDni,String urlRegalo,String urlImagen,float precioRegalo,String idRegalo){
		nombre=unNombre
		apellido=unApellido
		fechaDeCumpleanios=unaFechaDeCumpleanios
		dni=unDni
		regaloActual=new Regalo(unaFechaDeCumpleanios,urlRegalo,urlImagen,precioRegalo,idRegalo)
		historialDeRegalos=new ArrayList<Regalo>()
	}

	Set<Role> getAuthorities() {
		UsuarioRole.findAllByUsuario(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}
	
	def confirmarRegaloActual(){
		regaloActual.regalado=true
		historialDeRegalos.add(regaloActual)
		this.regaloActual=new Regalo(fechaDeCumpleanios,"","",0,"")
		Date unaFecha=new Date()
		unaFecha.setYear(unaFecha.getYear()+1)
		unaFecha.clearTime()
		regaloActual.setFechaRegalado(unaFecha)
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
