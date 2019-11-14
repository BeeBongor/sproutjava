import designPattern.createobject.BuilderPattern;
import org.junit.jupiter.api.Test;


public class TestBuilderPattern {


    @Test
    public void test(){
        BuilderPattern builderPattern = new BuilderPattern().key1("t1");
//        System.out.println(builderPattern.key);
        final Hero hero = new Hero();
        Thread t1 = new Thread(){
          public void run(){

              hero.addHp();
          }
        };



    }

    class Hero{
        public int hp = 1000;

        public synchronized  void addHp(){
            this.hp++;
        }

        public synchronized  void decreaseHp(){
            this.hp--;
        }

    }

}
