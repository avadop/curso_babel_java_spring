package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Contacto;

@Repository("agendaDao")
public class AgendaDaoImpl implements AgendaDao {
		@Autowired
		private JdbcTemplate template;
		
		@Override
		public boolean addContacto(Contacto contacto) {
			String sql="Insert into contactos (nombre,email,edad) values(?,?,?)";
			int cantidadInsertada = this.template.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
			return cantidadInsertada > 0;
		}

		@Override
		public Contacto buscarContacto(String email) {
			String sql="select * from contactos where email =?";
			List<Contacto> contactos  = this.template.query(sql,
					(rs,f) ->  new Contacto(rs.getInt("idContacto"),rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")), 
					email);
			return contactos.size() > 0 ? contactos.get(0) : null;
		}
		
		@Override
		public boolean deleteContacto(int id) {
			String sql="delete from contactos where idContacto =?";
			return this.template.update(sql,id)>0; 
		}

		@Override
		public boolean deleteContacto(String email) {
			String sql="delete from contactos where email =?";
			return this.template.update(sql,email)>0; 
		}

		@Override
		public List<Contacto> mostrarContactos() {
			String sql="select * from contactos";
			return this.template.query(sql,(rs,f)->new Contacto(rs.getInt("idContacto"),rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")));
		}



}
