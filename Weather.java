package Weather;

import java.io.IOException;
import java.io.InputStream;	
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather
{
	public static String getWeather(String message, Model model) throws IOException
	{
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=65e4ce99c89b013cdbc522c078860b59");
		Scanner in = new Scanner((InputStream)url.getContent());
		String result = "";
		while(in.hasNext())
		{
			result += in.nextLine();
		}
		in.close();
		JSONObject object = new JSONObject(result);
		model.setName(object.getString("name"));
		JSONObject main = object.getJSONObject("main");
		model.setTemp(main.getDouble("temp"));
		model.setTemp_min(main.getDouble("temp_min"));
		model.setTemp_max(main.getDouble("temp_max"));
		model.setHumidity(main.getDouble("humidity"));
		model.setPressure(main.getDouble("pressure"));
		JSONArray getArray = object.getJSONArray("weather");
		for(int i = 0; i < getArray.length(); i++)
		{
			JSONObject obj = getArray.getJSONObject(i);
			model.setIcon((String)obj.get("icon"));
			model.setMain((String)obj.get("main"));
			model.setWeather((String)obj.get("description"));
		}
		JSONObject wind = object.getJSONObject("wind");
		model.setWind(wind.getDouble("speed"));
		JSONObject sys = object.getJSONObject("sys");
		model.setCountry((String)sys.get("country"));
		               return "City: "+ model.getName() 						   + "\n" +
							  "Country: " + model.getCountry() 					   + "\n" +
							  "Minimal temperature: " + model.getTemp_min() + "C"  + "\n" +
				              "Temperature: " + model.getTemp() 			+ "C"  + "\n" +
				              "Maximal temperature: " + model.getTemp_max() + "C"  + "\n" +
				              "Speed of wind: " + model.getWind()  				   + "\n" +
				              "Humidity: " + model.getHumidity()   		    + "%"  + "\n" +
				              "Pressure: " + model.getPressure()   				   + "\n" +
				              "Weather: "  + model.getMain()                       + "\n" +
				              "Description: " + model.getWeather() 	 			   + "\n" +
				              "http://openweathermap.org/img/wn/" + model.getIcon() + ".png";
	}
}

