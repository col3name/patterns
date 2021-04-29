package ru.mikushov.ood.lab2.task5.observable;

import ru.mikushov.ood.lab2.task5.observer.WeatherInfo;

public class WeatherData extends ObservableBase<WeatherInfo> {
    private double temperature = 0.0;
    private double humidity = 0.0;
    private double pressure = 760.0;

    public void setMeasurements(double temp, double humidity, double pressure) {
        this.humidity = humidity;
        this.temperature = temp;
        this.pressure = pressure;

        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    @Override
    protected WeatherInfo getChangedData() {
        return new WeatherInfo(getTemperature(), getHumidity(), getPressure());
    }
}
