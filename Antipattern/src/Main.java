import models.WeatherModel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* Antipattern Beispiel
        * - Manuelle Verwaltung der Observer -> Mögliche Code duplizierung
        * - Observable verwaltet nicht seine subscriptions selbst -> Möglice Fehler
        * - "Separation ob Concerns" -> Die Main Methode sollte aufgeteilt werden
        * - "Open/Closed Principle" Main ist nicht geschlossen für Änderungen
        * - "Law of Demeter" "principle of least knowledge" die main Methode weiß zu viel
        * - "Dont repeat yourself" -> Wiederholte forEach
        * - "Inversion of Control" -> Main ist für alles Zuständig */


        var phoneObserver = new WeatherModelObserver();
        var computerObserver = new WeatherModelObserver();

        var observers = new ArrayList<WeatherModelObserver>();

        observers.add(phoneObserver);
        observers.add(computerObserver);

        // Create a new WeatherModel
        var currentWeatherModel = WeatherModel.getRandomWeatherModel();

        // Inform all "Observers" about new weather
        observers.forEach(o -> o.setCurrentWeatherModel(currentWeatherModel));

        // Create a new WeatherModel
        var newCurrentWeatherModel = WeatherModel.getRandomWeatherModel();

        // Inform all "Observers" about new weather
        observers.forEach(o -> o.setCurrentWeatherModel(newCurrentWeatherModel));

        // Manually remove subscriber
        observers.remove(phoneObserver);
    }
}