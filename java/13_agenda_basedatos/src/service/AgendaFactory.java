package service;

public class AgendaFactory {

	//As� la presentacion no se va a enterar de cu�l es la impl que le llega
	public static AgendaService getAgendaService() {
		//return new AgendaServiceImpl();
		return new AgendaServiceJdbcImpl();
	}
}
