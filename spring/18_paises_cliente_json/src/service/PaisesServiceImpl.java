package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService{
	String url = "https://restcountries.eu/rest/v2/all";
	@Autowired
	RestTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> getAllPaises() throws ParseException {
		String cadenaJson = template.getForObject(url, String.class);
		JSONParser parser = new JSONParser(); 
		JSONArray array = (JSONArray) parser.parse(cadenaJson); 
		List<Pais> paises = new ArrayList<Pais>();
		array.forEach(ob -> {
			JSONObject datos = (JSONObject) ob;
			paises.add(new Pais((String)datos.get("name"), 
					(long)datos.get("population"), 
					(String)datos.get("flag")));
		});
		return paises;
	}

	@Override
	public Pais getPais(String nombre) throws ParseException {
		List<Pais> paises = this.getAllPaises();
		Optional<Pais> op = paises.stream().filter(p -> p.getNombre().equals(nombre)).findFirst();
		if(op.isPresent())
			return op.get();
		else return null;
	}
	

	


}
