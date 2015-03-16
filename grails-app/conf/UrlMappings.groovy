class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/api/usuarios"(controller: 'usuarioRest', action: 'index', method: 'get')
		"/api/usuarios/$id"(controller: 'usuarioRest', action: 'edit', method: 'get')
		"/api/usuarios/$id"(controller: 'usuarioRest', action: 'delete', method: 'delete')
		"/api/usuarios/$id"(controller: 'usuarioRest', action: 'update', method: 'put')
		"/api/usuarios"(controller: 'usuarioRest', action: 'save', method: 'post')
		
		"/ABMRest"(view: "/rest/ABMRest")
		
		//"/ABMRest"(resources:"Usuario")
		
		

        "/"(controller:'usuarios',action:'index')
        "/$empresa"(controller:'empresa',action:'index')
        "500"(view:'/error')
	}
}
