package com.company.state;

public class BookExample {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}

interface State
{
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

class GumballMachine
{
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state=soldOutState;
    int count=0;
    public GumballMachine(int numberGumballs)
    {
        soldOutState=  new SoldOutState(this);
        noQuarterState= new NoQuarterState(this);
        hasQuarterState= new HasQuarterState(this);
        soldState= new SoldState(this);
        this.count=numberGumballs;
        if(numberGumballs>0)
        {
            state=noQuarterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter()
    {
        state.ejectQuarter();
    }

    public void turnCrank()
    {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state)
    {
        this.state=state;
    }

    void releaseBall()
    {
        System.out.println("Gumball is coming");
        if(count != 0)
        {
            count-=1;
        }
    }

    int getCount()
    {
        return this.count;
    }
}

class NoQuarterState implements State
{
    GumballMachine gumballMachine;
    public NoQuarterState(GumballMachine gumballMachine)
    {
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted quarter!");
        gumballMachine.setState(gumballMachine.hasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You havent inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("No quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("Need to pay first!");
    }
}

class HasQuarterState implements State
{
    GumballMachine gumballMachine;
    public HasQuarterState(GumballMachine gumballMachine)
    {
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cant insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.noQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class SoldState implements State
{
    GumballMachine gumballMachine;
    public SoldState(GumballMachine gumballMachine)
    {
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sorry you already turned the crank");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount()>0)
        {
            gumballMachine.setState(gumballMachine.noQuarterState);
        }
        else
        {
            System.out.println("Out of balls");
            gumballMachine.setState(gumballMachine.soldOutState);
        }
    }
}

class SoldOutState implements State
{

    GumballMachine gumballMachine;
    public SoldOutState(GumballMachine gumballMachine)
    {
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sold out!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sold out!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sold out!");
    }

    @Override
    public void dispense() {
        System.out.println("Sold out!");
    }
}
