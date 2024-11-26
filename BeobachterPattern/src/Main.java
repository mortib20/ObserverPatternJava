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

        System.out.println("------ Abonnieren des Observables ------");
        weatherObservable.subscribe(phoneObserver);
        weatherObservable.subscribe(computerObserver);

        System.out.println("------ 4x update ------");
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());

        System.out.println("------ PhoneObserver unsubscribe ------");
        weatherObservable.unsubscribe(phoneObserver);

        System.out.println("------ Nur der Computer wird informiert ------");
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());

        System.out.println("------ ComputerObserver unsubscribe ------");
        weatherObservable.unsubscribe(computerObserver);

        System.out.println("------ Update aber keiner wird informiert ------");
        weatherObservable.notifyObservers(WeatherModel.getRandomWeatherModel());

        System.out.println("------  Ende des Codes... ------ ");
    }
}