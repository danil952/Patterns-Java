package com.company;

public class Main {

    public static void main(String[] args) {

        Duck duck1 = new RedHeadDuck();
        duck1.performFly();
        duck1.performQuack();
        duck1.setQuackBehaviour(new NoQuack());
        duck1.performQuack();
    }
}
