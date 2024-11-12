package models;

import java.util.ArrayList;
import java.util.Random;

public class WeatherModel {
    public long time;
    public float temperature;
    public String description;

    public static WeatherModel getRandomWeatherModel() {
        var random = new Random();
        var descriptions = new ArrayList<String>();

        descriptions.add("Sunny");
        descriptions.add("Rain");
        descriptions.add("Cloudy");

        var wm = new WeatherModel();

        wm.time = System.currentTimeMillis() / 1000L;
        wm.temperature = random.nextFloat(0, 50);
        wm.description = descriptions.get(random.nextInt(0, descriptions.size()));

        return wm;
    }
}
