package com.company;

public class Main {

    public static void main(String[] args) {

        WeatherData data = new WeatherData();
        CustomDisplay display = new CustomDisplay(data);
        data.setMeasurements(72.4f,55.6f ,65.0f );
    }
}
