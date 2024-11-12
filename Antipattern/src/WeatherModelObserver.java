import models.WeatherModel;

public class WeatherModelObserver {
    private final ObserverType type;
    public WeatherModel currentWeather;

    public WeatherModelObserver(ObserverType type) {
        this.type = type;
    }

    public void setCurrentWeatherModel(WeatherModel wm) {
        currentWeather = wm;

        if (type == ObserverType.Phone) {
            System.out.printf("📱 New weather: %s\n", wm.description);
        }

        if (type == ObserverType.Computer) {
            System.out.printf("🖥️ New weather: %s\n", wm.description);
        }

    }
}
