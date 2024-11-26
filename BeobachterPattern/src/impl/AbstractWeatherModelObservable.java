package impl;

import models.WeatherModel;
import pattern.IObservable;
import pattern.IObserver;

import java.util.ArrayList;

public class AbstractWeatherModelObservable implements IObservable<WeatherModel> {
    private final ArrayList<IObserver<WeatherModel>> observers = new ArrayList<>();

    @Override
    public void subscribe(IObserver<WeatherModel> observer) {
        observers.add(observer);
        System.out.printf("🟩 %s subscribed from WeatherModelObservable with %s\n", observer.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    @Override
    public void unsubscribe(IObserver<WeatherModel> observer) {
        if (observer == null || !observers.contains(observer)) {
            return;
        }

        observers.remove(observer);
        System.out.printf("🟥 %s unsubscribed from WeatherModelObservable with %s\n", observer.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    public void notifyObservers(WeatherModel weatherModel) {
        observers.forEach(observer -> observer.update(weatherModel));
    }
}
