package _1.TS;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TsApplicationTests {

	/*
	 * Test para comprobar la conexión a la API de Dataestur.
	 * Se verifica que se puede establecer una conexión y que el código de respuesta es 200.
	 */
	@Test
	void testConexion() {
		Logger logger = LoggerFactory.getLogger(TsApplicationTests.class);
		String getUrlSites = "https://dataestur.azure-api.net/API-SEGITTUR-v1/ETR_DL?Pa%C3%ADs%20destino=Todos&CCAA%20de%20residencia=Todos&CCAA%20de%20destino=Todos";
		try {
			java.net.URL url = new java.net.URL(getUrlSites);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();

			int responseCode = conn.getResponseCode();
			assert(responseCode == 200);
			conn.disconnect();
		} catch (Exception e) {
			assert false : "Excepción durante la conexión: " + e.getMessage();
		}
	}

	/*
	 * Test para comprobar la llamada a la API y la obtención del archivo.
	 */
	@Test
	void testGetArchivoTurismoResidentes() {
  		//'https://dataestur.azure-api.net/API-SEGITTUR-v1/ETR_DL?Pa%C3%ADs%20destino=Todos&CCAA%20de%20residencia=Todos&CCAA%20de%20destino=Todos';
		Logger logger = LoggerFactory.getLogger(TsApplicationTests.class);
		
		List<String> PaisDestino = new java.util.ArrayList<>();
		List<String> ComunidadAutonomaEs = new java.util.ArrayList<>();
		PaisDestino.add("España");
		ComunidadAutonomaEs.add("Andalucía");
		String getUrlSites = "https://dataestur.azure-api.net/API-SEGITTUR-v1/ETR_DL?Pa%C3%ADs%20destino=" + PaisDestino.get(0) + 
		"&CCAA%20de%20residencia=" + ComunidadAutonomaEs.get(1) +
		"Todos&CCAA%20de%20destino=" + ComunidadAutonomaEs.get(0);
		try {
			java.net.URL url = new java.net.URL(getUrlSites);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			assert(responseCode == 200);
			logger.info("Conexión exitosa con la API. Código de respuesta: " + responseCode);
			conn.disconnect();
		} catch (Exception e) {
			assert false : "Excepción durante la conexión: " + e.getMessage();
		}
	}

}
