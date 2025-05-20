package _1.TS.Europeana;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecolectarDatos {

    // Método para obtener datos de la API de Europeana
    public String obtenerDatosPerfilEuropeana(String endpoint) {
        endpoint = "https://api.europeana.eu/set/search?wskey=tleilcultb&query=creator%3A1eb0457d-9cc1-421e-adaf-ac5d9d4d5ab9+type%3ABookmarkFolder&profile=items";
        StringBuilder resultado = new StringBuilder();
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            int respuesta = conexion.getResponseCode();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    resultado.append(linea);
                }
                lector.close();
            } else {
                System.out.println("Error al conectar con la API de Europeana: " + respuesta);
            }
            conexion.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado.toString();
    }
}
