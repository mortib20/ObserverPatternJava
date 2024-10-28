import impl.WeatherModelComputerObserver;
import impl.WeatherModelObservable;
import impl.WeatherModelPhoneObserver;
import models.WeatherModel;

public class Main {
    public static void main(String[] args) {
        var weatherObservable = new WeatherModelObservable();

        var phoneObserver = new WeatherModelPhoneObserver();
        var computerObserver = new WeatherModelComputerObserver();

        weatherObservable.subscribe(phoneObserver);
        weatherObservable.subscribe(computerObserver);

        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());

        weatherObservable.unsubscribe(phoneObserver);
        weatherObservable.unsubscribe(computerObserver);

        System.out.println();
    }
}