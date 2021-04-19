package com.company;

public class CustomDisplay implements Observer,Displays {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    public  CustomDisplay(Subject weatherData)
    {
        this.weatherData = weatherData;
        weatherData.register(this);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Temp: "+temp+"; Humidity: "+humidity+"; Pressure: "+pressure);
    }
}
