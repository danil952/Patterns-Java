package com.company;

public class CarAdapter extends Car {
    Car car;
    public CarAdapter(Car car)
    {
        this.car=car;
    }

    public int getPrice()
    {
        int price=0;
        if(car.getType()==Type.CITY_CAR)
        {
            price=1000000;
        }
        else if(car.getType()==Type.SUV)
        {
            price=1500000;
        }
        else
        {
            price=3500000;
        }
        return price;

    }
}
