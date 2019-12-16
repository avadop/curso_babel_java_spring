package service;

public class AgendaFactory {

	//Así la presentacion no se va a enterar de cuál es la impl que le llega
	public static AgendaService getAgendaService() {
		//return new AgendaServiceImpl();
		return new AgendaServiceJdbcImpl();
	}
}
