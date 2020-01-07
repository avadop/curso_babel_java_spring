package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;

@Service("reservasService")
public class ReservasServiceImpl implements ReservasService {
	@Autowired
	ReservasDao reservas;
	@Autowired
	RestTemplate template;
	String url = "http://servicio-vuelos";
	
	@Transactional
	@Override
	public void realizarReserva(Reserva reserva, int totalPersonas) {
		/*Como no le pasamos nada en el cuerpo le pasamos un null*/
		template.put(url + "/vuelos/"+reserva.getVuelo()+"/"+totalPersonas,null);
		reservas.generarReserva(reserva);
	}

	@Override
	public List<Reserva> getReservas() {
		return this.reservas.getReservas();
	}

}
