package designPattern.createobject;

/**
 * 静态内部类实现单例模式
 *
 * 延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
 */
public class InnerSingleton {

    private  InnerSingleton(){}

    private static class InnerClass{
        private static final InnerSingleton instance = new InnerSingleton();
    }

    public InnerSingleton getInstance(){
        return InnerClass.instance;
    }

}
