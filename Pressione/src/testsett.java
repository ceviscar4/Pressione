import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public class testsett {

	public static void main(String[] args) throws ParseException {
		try {

	        //StringBuilder buffer = new StringBuilder();

	        String nomecitta = "Los Angeles";
	        //String units = "metric";
	        String Apikey = "aa0854721ceebf98625f7753971cd283";

	        String url_String = "https://api.openweathermap.org/data/2.5/forecast?q=" + nomecitta + "&appid=" + Apikey; //+ "&units=" + units;

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
	        Object main_press = obj.get("list");
	        System.out.println(main_press);
	       
	        
	        //Cast del campo main a String
	        String value = main_press.toString();
         
	                    
	        /*Indice del carattere iniziale:
	                   |
	                   v 
	        "pressure":0000*/
	        int index = (value.indexOf("dt_txt") +9);

	        /*Indice del carattere finale:
	                      |
	                      v 
	        "pressure":0000*/
	        int index_end = (value.indexOf("weather") -12);

	        String pressure = new String();
	       // while(pressure.equals(null)) {
	        //Leggo da indice iniziale ad indice finale
	        pressure = value.substring(index, index_end);
	        System.out.println(pressure);
            //Date d=null;
	       // DateFormat formatodata=DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.ITALIAN);
	        //d=formatodata.parse(pressure);
	        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
	      Date d=formato.parse(pressure);
	        System.out.println("output "+formato.format(d));
	      
	         
	        //Cast del campo main a String
	        //String value = main_press.toString();
          // do {
	        
	        
            
	        /*Indice del carattere iniziale:
	                   |
	                   v 
	        "pressure":0000*/
	       // int index = (value.indexOf("pressure") +10);

	        /*Indice del carattere finale:
	                      |
	                      v 
	        "pressure":0000*/
	        /*int index_end = (value.indexOf("sea_level") -2);

	        String pressure = new String();
	       // while(pressure.equals(null)) {
	        //Leggo da indice iniziale ad indice finale
	        pressure = value.substring(index, index_end);
	        System.out.println(pressure);
            
	        //Adesso scrivo sul file
	        FileWriter fd = new FileWriter("pressuresett.txt");
	        fd.write("Pressione: " + pressure);
	        //chiudo file
	        fd.close();*/
	        
	        

	        
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
