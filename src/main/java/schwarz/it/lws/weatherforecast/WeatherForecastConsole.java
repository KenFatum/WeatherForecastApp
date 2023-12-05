package schwarz.it.lws.weatherforecast;

import java.util.Scanner;

public class WeatherForecastConsole {
    private static final boolean FOREVER = true;
    private static final Scanner scanner = new Scanner(System.in);
    private final WeatherForecastClient weatherForecastClient;

    public WeatherForecastConsole(WeatherForecastClient weatherForecastClient) {
        this.weatherForecastClient = weatherForecastClient;
    }

    public void run() {
        while (FOREVER) {
            System.out.println("- - - - Weather Forecast - - - - - - - - - - - - - - - - ");
            System.out.print("Gewünschten Ort eingeben (x-beenden):");
            String city = scanner.nextLine();

            if (city.equals("exit") || city.equals("x")) {
                System.out.println("Bye Bye ...");
                break;
            }
            weatherForecastClient.getWeatherData(city);
        }
    }
}
