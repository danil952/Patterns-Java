package com.company;

public class SellFacade {
    public String getSellInfo()
    {
        Director director = Director.getInstance("Danil");
        director = Director.getInstance("Bulat");
        System.out.println("Director name: "+director.name);
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        Car preparedToSellCar=new CarAdapter(car);
        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        String s=("\nCar manual built:\n" + carManual.print());
        s=s+"\nCar price:\n"+((CarAdapter) preparedToSellCar).getPrice();
        return(s);
    }
}
