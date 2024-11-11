import impl.WeatherModelComputerObserver;
import impl.WeatherModelObservable;
import impl.WeatherModelPhoneObserver;
import models.WeatherModel;

public class Main {
    public static void main(String[] args) {
        // Instanziieren des Observable
        var weatherObservable = new WeatherModelObservable();

        // Instanziieren der Observer
        var phoneObserver = new WeatherModelPhoneObserver();
        var computerObserver = new WeatherModelComputerObserver();

        // Abonnieren der Beobachter
        weatherObservable.subscribe(phoneObserver);
        weatherObservable.subscribe(computerObserver);

        // Neue Informationen an die Observables
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());

        // PhoneObserver wird nicht mehr informiert
        weatherObservable.unsubscribe(phoneObserver);

        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());

        weatherObservable.unsubscribe(computerObserver);

        // Keine Meldungen mehr in der Konsole
        System.out.println("Nur der Computer wird informiert.");
        weatherObservable.updateWeatherModel(WeatherModel.getRandomWeatherModel());

        System.out.println("Ende des Codes...");
    }
}