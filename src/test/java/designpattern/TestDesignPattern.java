package designpattern;

import designPattern.strategypattern.BlackDuck;
import designPattern.strategypattern.Duck;
import designPattern.strategypattern.RealBehavier;
import designPattern.strategypattern.WhiteDuck;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Set;

public class TestDesignPattern {

    @Test
    public void testStrategyPattern(){
        Duck duck = new BlackDuck();

        duck.quake();
        duck = new WhiteDuck();
        duck.quake();
        duck.setBehavier(new RealBehavier());
        duck.quake();
    }



}
