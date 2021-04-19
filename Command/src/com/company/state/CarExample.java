package com.company.state;

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.turnOnEngine();
        car.changeSpeed(80);
        car.turnOffEngine();
        car.turnOnEngine();
        car.changeSpeed(0);
        car.turnOffEngine();
    }
}

interface CarState
{
    void turnOnEngine();
    void turnOffEngine();
    void changeSpeed(int speed);
}

class Car
{
    CarState engineOn;
    CarState engineOff;
    CarState moving;

    CarState state;
    int speed=0;

    public Car()
    {
        engineOn=new engineOn(this);
        engineOff=new engineOff(this);
        moving=new moving(this);
        state=engineOff;
    }

    public void turnOnEngine()
    {
        state.turnOnEngine();
    }

    public void turnOffEngine()
    {
        state.turnOffEngine();
    }

    public void changeSpeed(int speed)
    {
        state.changeSpeed(speed);
    }

    void setState(CarState state)
    {
        this.state=state;
    }

    void setSpeed(int speed)
    {
        this.speed=speed;
    }
}

class engineOn implements CarState
{
    Car car;
    public engineOn(Car car)
    {
        this.car=car;
    }

    @Override
    public void turnOnEngine() {
        System.out.println("Engine is running!");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("Engine stopped");
        car.setState(car.engineOff);
    }

    @Override
    public void changeSpeed(int speed) {
        if(speed>0)
        {
            System.out.println("(__/__)");
            car.setState(car.moving);
            car.setSpeed(speed);
            System.out.println("Speed is: "+car.speed);
        }
        else
        {
            System.out.println("oops wrong value");
        }
    }
}

class engineOff implements CarState
{

    Car car;
    public engineOff(Car car)
    {
        this.car=car;
    }
    @Override
    public void turnOnEngine() {
        System.out.println("Turning on engine");
        car.setState(car.engineOn);
    }

    @Override
    public void turnOffEngine() {
        System.out.println("Engine is already stopped");
    }

    @Override
    public void changeSpeed(int speed) {
        System.out.println("Turn on engine first!");
    }
}

class moving implements CarState
{
    Car car;
    public moving(Car car)
    {
        this.car=car;
    }
    @Override
    public void turnOnEngine() {
        System.out.println("Engine is running!!!");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("Stop first!");
    }

    @Override
    public void changeSpeed(int speed) {
        if(speed==0)
        {
            car.setState(car.engineOn);
            car.setSpeed(speed);
            System.out.println("We stopped!");
        }
        else if(speed>0)
        {
            car.setSpeed(speed);
            System.out.println("Speed is: "+car.speed);
        }
        else
        {
            System.out.println("Wrong value!");
        }
    }
}
