package designPattern.strategypattern;

public class BlackDuck extends Duck {

    public BlackDuck(){
        super();
        this.behavier = new RealBehavier();
    }
}
