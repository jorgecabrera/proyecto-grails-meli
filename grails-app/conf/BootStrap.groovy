import java.util.Date;

import usuario.Usuario

class BootStrap {

	def init = {
		new Usuario("Pablo","Gallazzi", new Date().parse("yyyy-MM-dd","1992-04-08"),"36729233","http://articulo.mercadolibre.com.ar/MLA-547774777-celular-motorola-moto-g-xt-1032-8gb-gtia-1-ano-_JM","http://mla-s1-p.mlstatic.com/18980-MLA20163413669_092014-I.jpg",4449.99,"MLA547774777").save()
		new Usuario("Nicolas","De Giacomo", new Date().clearTime(),"36729235","http://vehiculo.mercadolibre.com.ar/MLA-545296217-yate-paradise-santana-38-pies-excelente-oportunidad-_JM","http://mla-s1-p.mlstatic.com/19260-MLA20168810935_092014-I.jpg",180000.0,"MLA545296217").save()
	}
	def destroy = {
	}
}
