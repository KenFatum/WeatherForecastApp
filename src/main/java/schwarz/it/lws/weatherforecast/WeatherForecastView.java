package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;

public class WeatherForecastView {

    private final WeatherResponseParser weatherResponseParser;

    public WeatherForecastView(WeatherResponseParser weatherResponseParser) {
        this.weatherResponseParser = weatherResponseParser;
    }

    public void show(JSONObject weather) {
        String city = weatherResponseParser.parseCity(weather);
        String currentWeather = weatherResponseParser.parseCurrentWeather(weather);
        Float currentTemperature = weatherResponseParser.parseCurrentTemperature(weather);
        Float minTemperature = weatherResponseParser.parseMinTemperature(weather);
        Float maxTemperature = weatherResponseParser.parseMaxTemperature(weather);
        int humidity = weatherResponseParser.parseHumidity(weather);
        String sunrise = weatherResponseParser.parseSunriseTime(weather);
        String sunset = weatherResponseParser.parseSunsetTime(weather);


        System.out.println("- - - - - - - - - - - -  - - - - - - - - - - - - - - - - ");
        System.out.printf("Das Wetter in %s\n", city);
        System.out.printf("\t%s bei %3.1f °C\n", currentWeather, currentTemperature);
        System.out.printf("\tmin Temperatur %3.1f °C\n", minTemperature);
        System.out.printf("\tmax Temperatur %3.1f °C\n", maxTemperature);
        System.out.printf("\tLuftfeuchtigkeit %d %%\n", humidity);
        System.out.printf("\tSonnenaufgang %s Uhr\n", sunrise);
        System.out.printf("\tSonnenuntergang %s Uhr\n", sunset);
        System.out.println();
        System.out.println();
    }

    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
