package serverBs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GeneradorRespuestas {

	private Map<String, String> respuestasss;

	public GeneradorRespuestas() {
		respuestasss = new HashMap<>();
		Respuestas("src/serverBs/respuestas.txt");
	}
	public void Respuestas(String ruta) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ruta));
			String linea;
			while ((linea = lector.readLine())!=null) {
				String[] divisor = linea.split(":");
				if (divisor.length==2) {
					String llave = divisor[0].trim();
					String respuesta = divisor[1].trim();
					respuestasss.put(llave, respuesta);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();}
	}
	public String darRespuesta(String pregunta) {
		for (String llave : respuestasss.keySet()) {
			if (pregunta.toLowerCase().contains(llave)) {
				return respuestasss.get(llave);
			}
			
		}
		return "Que pena contigo, no he podido entender lo que me dijiste";
	}

}
