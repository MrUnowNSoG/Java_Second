package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeatherAnalysis {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        List<WeatherData> weatherDataList = fetchDataFromApi("your_api_endpoint_here");

        weatherDataList.forEach(System.out::println);
    }

    private static List<WeatherData> fetchDataFromApi(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();

                return parseJsonToWeatherDataList(content.toString());
            } else {
                System.out.println("HTTP GET request failed with response code " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<WeatherData> parseJsonToWeatherDataList(String jsonString) {
        // Перетворення рядка JSON у список WeatherData
        return List.of(gson.fromJson(jsonString, WeatherData[].class));
    }

    private static List<WeatherData> findStationsWithContinuousRain(List<WeatherData> weatherDataList, int days) {
        return IntStream.range(0, weatherDataList.size() - days + 1)
                .filter(i -> weatherDataList.subList(i, i + days)
                        .stream().allMatch(data -> data.getPrecipitation() > 0))
                .mapToObj(i -> weatherDataList.get(i))
                .collect(Collectors.toList());
    }

    private static List<WeatherData> findStationsWithTemperatureIncrease(List<WeatherData> weatherDataList, int days, double temperatureIncrease) {
        return IntStream.range(0, weatherDataList.size() - days + 1)
                .filter(i -> weatherDataList.subList(i, i + days)
                        .stream()
                        .mapToDouble(WeatherData::getTemperature)
                        .average()
                        .orElse(0) - weatherDataList.get(i).getTemperature() >= temperatureIncrease)
                .mapToObj(i -> weatherDataList.get(i))
                .collect(Collectors.toList());
    }

    private static void calculateMonthlyAverages(List<WeatherData> weatherDataList) {
        Map<Month, Double> averageTemperatureByMonth = weatherDataList.stream()
                .collect(Collectors.groupingBy(data -> data.getDate().getMonth(),
                        Collectors.averagingDouble(WeatherData::getTemperature)));

        Map<Month, Double> averageHumidityByMonth = weatherDataList.stream()
                .collect(Collectors.groupingBy(data -> data.getDate().getMonth(),
                        Collectors.averagingDouble(WeatherData::getHumidity)));

        Map<Month, Double> averagePrecipitationByMonth = weatherDataList.stream()
                .collect(Collectors.groupingBy(data -> data.getDate().getMonth(),
                        Collectors.averagingDouble(WeatherData::getPrecipitation)));

        System.out.println("Average Temperature by Month: " + averageTemperatureByMonth);
        System.out.println("Average Humidity by Month: " + averageHumidityByMonth);
        System.out.println("Average Precipitation by Month: " + averagePrecipitationByMonth);
    }

    private static void findMonthWithHighestWindSpeed(List<WeatherData> weatherDataList) {
        Map<Month, Double> averageWindSpeedByMonth = weatherDataList.stream()
                .collect(Collectors.groupingBy(data -> data.getDate().getMonth(),
                        Collectors.averagingDouble(WeatherData::getWindSpeed)));

        Month monthWithHighestWindSpeed = averageWindSpeedByMonth.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Month with Highest Wind Speed: " + monthWithHighestWindSpeed);
    }
}