package designPattern.strategypattern;

public class Duck {
    Behavier behavier;

    public void quake(){
        behavier.behavier();
    }

    /**
     * 动态设定行为
     */
    public void setBehavier(Behavier behavier){
        this.behavier = behavier;
    }
}
