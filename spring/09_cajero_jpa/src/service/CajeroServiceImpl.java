package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CuentasDao;
import dao.MovimientosDao;
import model.Cuenta;
import model.Movimiento;

@Service("cajeroService")
public class CajeroServiceImpl implements CajeroService {
	
	@Autowired
	@Qualifier("cuentasDao") //Indica el id del objeto en particular que queremos inyectar 
	private CuentasDao cuentas;
	@Autowired
	private MovimientosDao movimientos;
	
	@Override
	public Cuenta buscarCuenta(int numCuenta) {
		return this.cuentas.getCuenta(numCuenta);
	}

	@Override
	public double getSaldo(int numCuenta) {
		return this.cuentas.getCuenta(numCuenta).getSaldo();
	}

	@Override
	public List<Movimiento> getAllMovimientos(int numCuenta) {
		return this.movimientos.getAllMovimientos(numCuenta);
	}
	
	@Transactional
	@Override
	public void ingresar(int numCuenta, double cantidad) {
		Cuenta cuenta = this.cuentas.getCuenta(numCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		this.cuentas.updateCuenta(cuenta);
		this.movimientos.addMovimiento(new Movimiento(0, cantidad, new Date(),numCuenta, "ingreso"));
	}
	
	@Transactional
	@Override
	public boolean extraccion(int numCuenta, double cantidad) {
		Cuenta cuenta = this.cuentas.getCuenta(numCuenta);
		double resta = cuenta.getSaldo() - cantidad;
		if(resta < 0)
			return false;
		else {
			this.movimientos.addMovimiento(new Movimiento(0,cantidad, new Date(),numCuenta,"extraccion"));
			cuenta.setSaldo(resta);
			this.cuentas.updateCuenta(cuenta);
			return true;
		}
	}

}
