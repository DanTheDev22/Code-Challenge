package com.danthedev22.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private Forecast forecast;

    @Data
    public static class Forecast {
        private ForecastDay forecastday[];

        @Data
        public static class ForecastDay {
            private String  date;
            private Day day;
            private Hour hour[];

            @Data
            public static class Day {
                private double maxtemp_c;
                private double mintemp_c;
                private int avghumidity;
                private double maxwind_kph;
            }

            @Data
            public static class Hour {
                private String wind_dir;
            }
        }
    }
}
