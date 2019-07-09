package Weather;

public class Model
{
	private String name, icon,main,country,weather; // weather => For example Rain: what rain? light? Average? Strong? Squall?
	private Double temp,humidity,pressure,temp_min,temp_max,wind; 
	public Double getWind() 
	{
		return wind;
	}
	public void setWind(Double wind)
	{
		this.wind = wind;
	}
	public String getWeather() 
	{
		return weather;
	}
	public void setWeather(String weather)
	{
		this.weather = weather;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min)
	{
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max)
	{
		this.temp_max = temp_max;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure)
	{
		this.pressure = pressure;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) 
	{
		this.icon = icon;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) 
	{
		this.main = main;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) 
	{
		this.temp = temp;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) 
	{
		this.humidity = humidity;
	}
	
	
}
