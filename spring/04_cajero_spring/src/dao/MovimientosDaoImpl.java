package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Movimiento;

@Repository("movimientosDao")
public class MovimientosDaoImpl implements MovimientosDao {
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Movimiento> getAllMovimientos(int idCuenta) {
		String sql = "select * from movimientos where idCuenta = ?";
		return this.template.query(sql, (rs,f) -> new Movimiento(
				rs.getInt("idMovimiento"),
				rs.getInt("idCuenta"),
				rs.getDate("fecha"),
				rs.getDouble("cantidad"), 
				rs.getString("operacion")
				), idCuenta);
	}

	@Override
	public void addMovimiento(Movimiento movimiento) {
		String sql = "insert into movimientos (idCuenta,fecha,cantidad,operacion) values (?,?,?,?)";
		this.template.update(sql,
				movimiento.getIdCuenta(), 
				movimiento.getFecha(),
				movimiento.getCantidad(), 
				movimiento.getOperacion());
	}

}
