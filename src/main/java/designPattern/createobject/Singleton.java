package designPattern.createobject;

/**
 * 懒加载单例模式，
 * 注意synchronized锁对象
 * 和volatile关键字的作用
 */
public class Singleton {


    private volatile Singleton singleton;

    private Singleton(){

    }

    public Singleton getSingleton(){
        if(singleton==null){
            synchronized(Singleton.class){
                if(singleton ==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
