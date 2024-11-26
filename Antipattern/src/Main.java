import models.WeatherModel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         * ------- Antipattern Beispiel ---------
         * - Manuelle Verwaltung der Observer → Mögliche Code duplizierung
         * - Observable verwaltet nicht seine subscriptions selbst → Mögliche Fehler
         * - "Separation of Concerns" → Main Methode sollte aufgeteilt werden
         * - "Open/Closed Principle" → Main ist nicht geschlossen für Änderungen
         * - "Law of Demeter" "principle of least knowledge" → Main Methode weiß zu viel
         * - "Dont repeat yourself" → Wiederholte forEach
         * - "Inversion of Control" → Main ist für alles Zuständig
         */


        var phoneObserver = new WeatherModelObserver(ObserverType.Phone);
        var computerObserver = new WeatherModelObserver(ObserverType.Computer);

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

        // Inform all "Observers" about new weather
        observers.forEach(o -> o.setCurrentWeatherModel(newCurrentWeatherModel));

        System.out.println("Ende des Codes...");
    }
}