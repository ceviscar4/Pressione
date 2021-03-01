import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class salvataggiopressionestorica {

	public static void main(String[] args) {
		try {

	        //StringBuilder buffer = new StringBuilder();

	        String nomecitta = "Los Angeles";
	        //String units = "metric";
	        String Apikey = "aa0854721ceebf98625f7753971cd283";

	        String url_String = "https://history.openweathermap.org/data/2.5/history/city?q=" + nomecitta + "&appid=" + Apikey; //+ "&units=" + units;

	        URL myURL = new URL(url_String); //Crea URL 

	        URLConnection openWeather = myURL.openConnection();
		    BufferedReader in = new BufferedReader(new InputStreamReader(openWeather.getInputStream()));

	        String line;
	        /*while((line = in.readLine()) != null) {
	            buffer.append(line);
	        }*/

	        line = in.readLine();
	        in.close();

	        //GENERO UN JSONObject per trovare il campo main
	        JSONObject obj = new JSONObject(line);
	        Object main_press = obj.get("main");
	        System.out.println(main_press);

	        //Cast del campo main a String
	        String value = main_press.toString();

	        /*Indice del carattere iniziale:
	                   |
	                   v 
	        "pressure":0000*/
	        int index = (value.indexOf("pressure") + 10);

	        /*Indice del carattere finale:
	                      |
	                      v 
	        "pressure":0000*/
	        int index_end = (value.indexOf("feels") - 2);

	        String pressure = new String();
	        //Leggo da indice iniziale ad indice finale
	        pressure = value.substring(index, index_end);
	        System.out.println(pressure);

	        //Adesso scrivo sul file
	        FileWriter fd = new FileWriter("pressure.txt");
	        for(int i=0;i<10;i++) {
	        	
	        	fd.append(pressure +" , ");
	        }
	        //fd.write("Pressione: " + pressure);
	        //chiudo file
	        fd.close();
	        

	        
	    }

	    catch(IOException e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	        System.exit(100);
	    }

	    catch(JSONException je) {
	        System.err.println(je.getMessage());
	        je.printStackTrace();
	        System.exit(100);
	    }

	}

}
