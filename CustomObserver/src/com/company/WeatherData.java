package com.company;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    public void measurementsChanged()
    {
        notifeAll();
    }


    @Override
    public void register(Observer o) {
        observers.add(o);

    }

    @Override
    public void remove(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i); }
    }

    @Override
    public void notifeAll() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temp, humidity, pressure); }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temp = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(); }
}
