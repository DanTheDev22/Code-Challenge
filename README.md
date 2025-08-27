# Weather Forecast App

A simple **Java console application** that retrieves the next day’s weather forecast for multiple cities using the [WeatherAPI.com](https://www.weatherapi.com/) API. The application prints a neatly formatted table with key weather metrics for each city.

---

## Features

- Fetches **next day forecast** for a list of cities: Chisinau, Madrid, Kyiv, and Amsterdam.  
- Displays the following data points in a **table format**:
  - Minimum Temperature (°C)  
  - Maximum Temperature (°C)  
  - Humidity (%)  
  - Wind Speed (kph)  
  - Wind Direction  
- Fully **console-based output** for easy visualization.

---

## Technologies Used

- **Java 17**  
- **Retrofit** – for HTTP requests to the WeatherAPI  
- **Lombok** – for boilerplate code reduction (getters/setters)  
- **Gson Converter Factory** – for JSON deserialization in Retrofit  
- **Gradle** – build and dependency management

---
