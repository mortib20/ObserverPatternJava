package impl;

import models.WeatherModel;
import pattern.IObserver;

public class WeatherModelComputerObserver implements IObserver<WeatherModel> {
    @Override
    public void onNext(WeatherModel weatherModel) {
        System.out.printf("🖥️ %s received new WeatherData { time: %d temperature: %f description: %s }\n", this.getClass().getSimpleName(), weatherModel.time, weatherModel.temperature, weatherModel.description);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
