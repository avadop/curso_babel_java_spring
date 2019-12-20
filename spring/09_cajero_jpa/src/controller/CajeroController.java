package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cuenta;
import service.CajeroService;


@Controller
public class CajeroController {
	@Autowired
	CajeroService cajero;
	
	//Muestra movimientos de un numeroCuenta + saldo
	@GetMapping(value="verMovimientos")
	public String getAllMovimientos(HttpServletRequest request, HttpSession session) {
		System.out.println("Saldo:"+ this.cajero.getSaldo((int)session.getAttribute("getNumCuenta")));
		request.setAttribute("getMovimientos", this.cajero.getAllMovimientos((int)session.getAttribute("getNumCuenta")));
		request.setAttribute("getSaldo", this.cajero.getSaldo((int)session.getAttribute("getNumCuenta")));
		return "movimientos";
	}
	
	//Realiza el ingreso
	@PostMapping(value="ingreso")
	public String ingreso(@RequestParam("cantidad") double cantidad, HttpSession session) {
		this.cajero.ingresar((int) session.getAttribute("getNumCuenta"), cantidad);
		return "menu";
	}
	//Realiza la extraccion
	@PostMapping(value="extraccion")
	public String extraccion(@RequestParam("cantidad") double cantidad, HttpSession session) {
		this.cajero.extraccion((int)session.getAttribute("getNumCuenta"), cantidad);
		return "menu";
	}
	//Acceso con la cuenta
	@PostMapping(value="accesoCliente")
	public String acceso(@RequestParam("numCuenta") int numCuenta, HttpSession session) {
		Cuenta cuenta = this.cajero.buscarCuenta(numCuenta);
		if(cuenta != null) {
			session.setAttribute("getNumCuenta", cuenta.getNumeroCuenta());
			return "menu";
		}
		else return "inicio";
	}
}
