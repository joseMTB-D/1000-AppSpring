package _1.TS;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TsApplicationTests {

	@Test
	void testConexion() {
		Logger logger = LoggerFactory.getLogger(TsApplicationTests.class);
		String getUrlSites = "https://dataestur.azure-api.net/API-SEGITTUR-v1/ETR_DL?Pa%C3%ADs%20destino=Todos&CCAA%20de%20residencia=Todos&CCAA%20de%20destino=Todos";
		try {
			java.net.URL url = new java.net.URL(getUrlSites);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();

			int responseCode = conn.getResponseCode();
			assert(responseCode == 200);

			try (java.io.BufferedReader in = new java.io.BufferedReader(
					new java.io.InputStreamReader(conn.getInputStream()))) {
				String inputLine;
				StringBuilder content = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
			}
			conn.disconnect();
		} catch (Exception e) {
			assert(false);
		}
	}

	/*
	 * Test para comprobar la llamada a la API y la obtención del archivo.
	 */
	@Test
	void testGet() {

	}

}
