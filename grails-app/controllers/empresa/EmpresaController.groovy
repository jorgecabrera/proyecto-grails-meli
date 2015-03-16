package empresa

class EmpresaController {

    def index() {
    	[empresas:Empresa.list()]
    }

    def verCumples(empresa){

    }
}
