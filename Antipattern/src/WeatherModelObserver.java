import models.WeatherModel;

public class WeatherModelObserver {
    public WeatherModel currentWeather;

    public void setCurrentWeatherModel(WeatherModel wm) {
        currentWeather = wm;
        System.out.printf("New weather: %s\n", wm.description);
    }
}
