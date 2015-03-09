package mail

class MailController {

	def persistenciaService
	def mail() {
		def regalosDelMes=persistenciaService.obtenerRegalosDelMes()
		float sumaTotal=0
		//regalosDelMes.each {sumaTotal+=it.getPrecioRegalo()}
		sendMail {
			to "pablogallazzi@gmail.com"
			subject "Monto total mensual"
			body "el monto total es de: " + sumaTotal.toString()
		}
	}
}
