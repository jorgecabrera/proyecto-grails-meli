package mail

class MailController {

	def persistenciaService

	def mail() {

		def regalosDelMes=persistenciaService.obtenerRegalosDelMes()
		def sumaTotal=0

		regalosDelMes.each {sumaTotal+=it.getPrecioRegalo()}
		def para = grailsApplication.config.cuenta.user
		sendMail {
			to para
			subject "Monto total mensual"
			body "el monto total es de: " + sumaTotal
		}
	}
}
