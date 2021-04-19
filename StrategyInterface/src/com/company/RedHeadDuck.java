package com.company;

public class RedHeadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Here is a Duck!");
    }
    public RedHeadDuck()
    {
        flyBehaviour=new FlyWithWings();
        quackBehaviour =new BigQuack();
    }
}
