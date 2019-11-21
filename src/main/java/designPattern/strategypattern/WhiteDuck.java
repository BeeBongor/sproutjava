package designPattern.strategypattern;

public class WhiteDuck extends Duck{
    public WhiteDuck(){
        this.behavier = new FakeBehavier();
    }
}
