package _1.TS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import _1.TS.Europeana.RecolectarDatos;

@SpringBootApplication
public class TsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsApplication.class, args);
		testConexion();
	}
	private static void testConexion() {
		RecolectarDatos recolectarDatos = new RecolectarDatos();
		String endpoint = "https://api.europeana.eu/set/search?wskey=tleilcultb&query=creator%3A1eb0457d-9cc1-421e-adaf-ac5d9d4d5ab9+type%3ABookmarkFolder&profile=items";
		String resultado = recolectarDatos.obtenerDatosPerfilEuropeana(endpoint);
		System.out.println("Conexión a la API de Europeana exitosa.");
		System.out.println("Datos obtenidos: " + resultado);
		System.out.println("Fin de la prueba de conexión.");
	}

}
