import java.util.Date
import usuario.*
import empresa.*
import regalo.Regalo

class BootStrap {

	def init = { servletContext ->
		def e1 = new Empresa(nombre: "MercadoLibre", cuit: "30765883")
		e1.save(failOnError: true, flush: true)

		// Este grupo utiliza un sistema bastante raro para asociar usarios. Basicamente, siempre tienen un regalo asociado
		// habiendo un tipo de regalo que se  lo interpreta como "no regalo"
		def u1 = new Usuario(
			nombre: "Fernando",
			apellido: "Niwes",
			fechaDeCumpleanios: new Date(2014, 9 ,14).clearTime(),
			dni: "28444666",
			regaloActual: new Regalo(new Date(2014, 9 ,14).clearTime(),"","",0,"")
		)
		e1.addToEmpleados(u1)
		u1.save(failOnError: true, flush: true)

		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError:true)
		def testUser = new User(username: 'admin', password: 'admin')
		e1.addToAdministradores(testUser)
		testUser.save(failOnError: true, flush: true)

		UserRole.create testUser, adminRole, true



		// def e1 = new Empresa(nombre:"hola", cuit:"1234")
		// def e2 = new Empresa(nombre: "chau", cuit:"4321")

		// def u1 = new Usuario("Pablo","Gallazzi", new Date().parse("yyyy-MM-dd","1992-04-08"),"36729233","http://articulo.mercadolibre.com.ar/MLA-547774777-celular-motorola-moto-g-xt-1032-8gb-gtia-1-ano-_JM","http://mla-s1-p.mlstatic.com/18980-MLA20163413669_092014-I.jpg",4449.99,"MLA547774777")
		// def u2 = new Usuario("Nicolas","De Giacomo", new Date().clearTime(),"36729235","http://vehiculo.mercadolibre.com.ar/MLA-545296217-yate-paradise-santana-38-pies-excelente-oportunidad-_JM","http://mla-s1-p.mlstatic.com/19260-MLA20168810935_092014-I.jpg",180000.0,"MLA545296217")
		
		// e1.addToEmpleados(u1)
		// e2.addToEmpleados(u2)

		// e1.save(flush:true)
		// e2.save(flush:true)
		// u1.save(flush:true)
		// u2.save(flush:true)
		// /*def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError:true)
		// def userRole = new Role(authority: 'ROLE_USER').save(flush: true, failOnError:true)

		// def testUser = new User(username: 'admin', password: 'admin')

		// //e1.addToEmpleados(u2)
		// //e1.addToAdministradores(testUser)
		// println e1.empleados.collect{it.nombre}
		
		// //e1.save(flush:true, failOnError:true)
		// //UserRole.create testUser, adminRole, true*/
	}
	def destroy = {
	}
}