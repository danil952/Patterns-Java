package com.company;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {
        Computer c = new Computer();
        User u = new User(new StartCommand(c),new StopCommand(c), new ResetCommand(c));
        u.StartComp();
        u.StopComp();
        u.ResetComp();

    }
}
class Log
{
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("/Users/danil/IdeaProjects/Command/src/com/company/config/config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
}
interface Command
{
    void execute();
}

class Computer
{
    void start()
    {
        System.out.println("Start");
    }

    void stop()
    {
        System.out.println("Stop");
    }

    void reset()
    {
        System.out.println("Reset");
    }
}

class StartCommand implements Command
{
    Computer comp;
    StartCommand(Computer comp)
    {
        this.comp=comp;
    }

    @Override
    public void execute() {
        comp.start();
        Log.LOGGER.log(Level.INFO,"Старт");
    }
}

class StopCommand implements Command
{
    Computer comp;
    StopCommand(Computer comp)
    {
        this.comp=comp;
    }

    @Override
    public void execute() {

        comp.stop();
        Log.LOGGER.log(Level.INFO,"Стоп");
    }
}

class ResetCommand implements Command
{
    Computer comp;
    ResetCommand(Computer comp)
    {
        this.comp=comp;
    }

    @Override
    public void execute() {
        comp.reset();
        Log.LOGGER.log(Level.INFO,"Рестарт");
    }
}

class User
{
    Command start;
    Command stop;
    Command reset;
    User(Command start,Command stop,Command reset)
    {
        this.start=start;
        this.stop=stop;
        this.reset=reset;
    }
    void StartComp()
    {
        start.execute();
    }

    void StopComp()
    {
        stop.execute();
    }

    void ResetComp()
    {
        reset.execute();
    }
}
