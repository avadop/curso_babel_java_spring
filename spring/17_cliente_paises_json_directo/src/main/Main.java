package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

/**
 * Vamos a acceder a un servicio externo manipulando la información directamente en JSON*/
public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		String url ="https://restcountries.eu/rest/v2/all";
		RestTemplate template = new RestTemplate();
		
		/*No lo podemos sacar directamente en json, asi que 
		 * sacamos la info como un string y luego lo cambiamos*/
		String cadenaJson = template.getForObject(url, String.class);
		JSONParser parser = new JSONParser(); //Hay que declararlo antes de usarlo.
		JSONArray array = (JSONArray) parser.parse(cadenaJson); //Tenemos el array de objetos json
		
		//Recorremos el array de objetos json
	/*	for(int i = 0; i < array.size(); i++) {
			//Transformamos cada cosi del array en un objeto
			JSONObject ob = (JSONObject) array.get(i);
			//Se le da la clave y devuelve el valor. Clave = nomb propiedad
			System.out.println(ob.get("name"));
		}*/
		
		//Podemos hacerlo con STREAMS
		array.forEach(ob -> System.out.println(((JSONObject)ob).get("name")));
	}

}
