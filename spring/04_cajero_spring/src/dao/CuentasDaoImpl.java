package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cuenta;

@Repository("cuentasDao")
public class CuentasDaoImpl implements CuentasDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public Cuenta getCuenta(int numCuenta) {
		String sql="select * from cuentas where numeroCuenta = ?";
		List<Cuenta> cuentas  = this.template.query(sql,
				(rs,f) ->  new Cuenta(
						rs.getInt("numeroCuenta"), 
						rs.getDouble("saldo"), 
						rs.getString("tipocuenta")
						), numCuenta);
		return cuentas.size() > 0 ? cuentas.get(0) : null;
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		String sql = "update cuentas set saldo = ?, tipocuenta = ? where numeroCuenta = ?";
		this.template.update(sql, cuenta.getSaldo(),cuenta.getTipo(),cuenta.getNumCuenta());
	}

}
