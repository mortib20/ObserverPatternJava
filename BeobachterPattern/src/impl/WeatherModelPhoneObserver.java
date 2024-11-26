package impl;

import models.WeatherModel;
import pattern.IObserver;

public class WeatherModelPhoneObserver implements IObserver<WeatherModel> {
    private WeatherModel lastWeatherModel;

    @Override
    public void update(WeatherModel weatherModel) {
        lastWeatherModel = weatherModel;

        System.out.printf("📱 %s received new WeatherData { time: %d temperature: %f description: %s }\n", this.getClass().getSimpleName(), weatherModel.time, weatherModel.temperature, weatherModel.description);
    }

}
