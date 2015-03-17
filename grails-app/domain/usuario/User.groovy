package usuario
import empresa.*

class User extends SuperUser{
	static belongsTo = [empresa: Empresa]
}
