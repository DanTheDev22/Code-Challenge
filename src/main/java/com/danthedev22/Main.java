package com.danthedev22;

import com.danthedev22.Exception.WeatherError;
import com.danthedev22.model.WeatherResponse;
import com.danthedev22.service.ApiClient;
import com.danthedev22.service.WeatherApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class Main {

    private static final String apiKey = "5c74b25cc52543b28c1182646252608";
    private static final List<String> cities = List.of("Chisinau", "Madrid", "Kyiv", "Amsterdam");
    private static final int configDays = 2;

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        WeatherApiService weatherApiService = client.createClient();

        System.out.printf("%-12s| %-12s| %-15s| %-15s| %-8s| %-10s| %-6s%n",
                "City", "Date", "MinTemperature", "MaxTemperature", "Humidity", "WindSpeed", "WindDirection");

        System.out.println("-------------------------------------------------------------------------------------------------");

        cities.forEach((city) -> fetchWeather(weatherApiService, city));
    }

    private static void fetchWeather(WeatherApiService weatherApiService,
                                     String city ) {
        try {
            Call<WeatherResponse> call = weatherApiService.getForecast(Main.apiKey, city, Main.configDays);
            Response<WeatherResponse> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                WeatherResponse.Forecast forecast = response.body().getForecast();
                WeatherResponse.Forecast.ForecastDay forecastDay = forecast.getForecastday()[1];
                WeatherResponse.Forecast.ForecastDay.Day day = forecastDay.getDay();
                WeatherResponse.Forecast.ForecastDay.Hour hour = forecastDay.getHour()[0];

                System.out.printf("%-12s| %-12s| %-15.1f| %-15.1f| %-8d| %-10.1f| %-6s%n",
                        city,forecastDay.getDate(),day.getMintemp_c(),day.getMaxtemp_c(),
                        day.getAvghumidity(),day.getMaxwind_kph(),hour.getWind_dir());
            } else {
                throw new WeatherError("Error Fetching Weather Api Response");
            }
        } catch (WeatherError e) {
            System.out.println(e.getCause());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}