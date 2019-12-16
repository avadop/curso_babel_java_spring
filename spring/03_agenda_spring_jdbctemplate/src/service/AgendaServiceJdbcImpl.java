package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Contacto;

@Service("agendaService")
public class AgendaServiceJdbcImpl implements AgendaService {
	//Inyeccion de dependencia
	//@Autowired //Esta anotacion busca entre todos los objetos que ha creado uno de ese tipo.	
	//private DataSource dataSource;
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public boolean addContacto(Contacto contacto) {
		String sql="Insert into contactos (nombre,email,edad) values(?,?,?)"; //consulta parametrizada
		int cantidadInsertada = this.template.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
		return cantidadInsertada > 0; //true si se ha añadido alguno, else false;
	}

	@Override
	public Contacto buscarContacto(String email) {
		String sql="select * from contactos where email =?";
		//No funciona con queryForObject, peta si no se encuentra el objeto
		//return this.template.queryForObject(sql, (rs,f) -> new Contacto(rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")), email);
		List<Contacto> contactos  = this.template.query(sql,
				(rs,f) ->  new Contacto(rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")), 
				email);
		return contactos.size() > 0 ? contactos.get(0) : null;
	}

	@Override
	public boolean deleteContacto(String key) {
		String sql="delete from contactos where email =?";
		return this.template.update(sql,key)>0; //Si hay alguna columna afectada devuelve true
	}

	@Override
	public List<Contacto> mostrarContactos() {
		String sql="select * from contactos";
		//Con la expresion lambda decimos a RowMapper que para el objeto de la fila actual nos devuelva un contacto
		return this.template.query(sql,(rs,f)->new Contacto(rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")));
	}

}
