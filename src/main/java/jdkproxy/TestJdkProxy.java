package jdkproxy;

/**
 * @author dengmingliang
 * @Description
 * @ClassName TestJdkProxy
 * @Date 2019/12/1 2:06 下午
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Fruit fruit = (Fruit) DynamicProxy.agent(Fruit.class,apple);
        fruit.show();
    }
}
