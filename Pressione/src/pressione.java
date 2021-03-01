import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class pressione {

	public static void main(String[] args) {
		try {

            StringBuilder buffer = new StringBuilder();

            String nomecitta = "Los Angeles";
	        String units = "metric";
            String Apikey = "aa0854721ceebf98625f7753971cd283";

            String url_String = "https://api.openweathermap.org/data/2.5/forecast?q=" + nomecitta + "&appid=" + Apikey + "&units=" + units;

            URL myURL = new URL(url_String); //Crea URL 

            URLConnection openWeather = myURL.openConnection();
		    BufferedReader in = new BufferedReader(new InputStreamReader(openWeather.getInputStream()));

            String line;
            /*final JSONObject obj = new JSONObject();
            obj=(JSONObject)JSONValue.parse(buffer);
            final JSONArray geodata = obj.getJSONArray("geodata");
            final int n = geodata.length();
            for (int i = 0; i < n; ++i) {
              final JSONObject person = geodata.getJSONObject(i);
              System.out.println(person.getInt("id"));
              System.out.println(person.getString("name"));
              System.out.println(person.getString("gender"));
              System.out.println(person.getDouble("latitude"));
              System.out.println(person.getDouble("longitude"));
            }*/
            while((line = in.readLine()) != null) {
                buffer.append(line);
            }

            in.close();
            System.out.println(buffer);
	   }
	 
	   
        catch(IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(100);
        }
	   
	

	 
  

	 
	  

        /*catch(MalformedURLException me) {
            System.err.println(me.getMessage());
            me.printStackTrace();
            System.exit(100);
        }*/

	}

}
