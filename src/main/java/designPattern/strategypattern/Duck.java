package designPattern.strategypattern;

public class Duck {
    Behavier behavier;

    public void quake(){
        behavier.behavier();
    }

    /**
     * ��̬�趨��Ϊ
     */
    public void setBehavier(Behavier behavier){
        this.behavier = behavier;
    }
}
