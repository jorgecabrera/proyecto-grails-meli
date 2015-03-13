import usuario.Role
import usuario.Usuario
import usuario.UsuarioRole

class BootStrap {

   def init = { servletContext ->

      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Usuario(username: 'admin', password: 'admin')
      testUser.save(flush: true)

      UsuarioRole.create testUser, adminRole, true
   }
}