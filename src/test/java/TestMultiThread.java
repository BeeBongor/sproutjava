import multithread.Consumer;
import multithread.MyStack;
import multithread.Producer;

import java.util.Arrays;

public class TestMultiThread extends Thread{


    ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"before");

    ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
//        Thread

//        new Producer(myStack, "������1").start();
//        new Producer(myStack, "������2").start();
//        new Consumer(myStack, "������1" ).start();
//        new Consumer(myStack, "������2" ).start();
//        new Consumer(myStack, "������3" ).start();
        TestMultiThread testMultiThread = new TestMultiThread();

        Thread thread = new Thread(testMultiThread);
        Thread thread2 = new Thread(testMultiThread);
        Thread thread3 = new Thread(testMultiThread);



        thread.start();

        thread2.start();
        thread3.start();
//        thread.start();

    }


    @Override
    public void run(){


        System.out.println(Thread.currentThread()+threadLocal.get());
        System.out.println(Thread.currentThread()+""+threadLocal2.get());
        threadLocal.set("after");
        threadLocal2.set(2);
        System.out.println(Thread.currentThread()+threadLocal.get());
        System.out.println(Thread.currentThread()+""+threadLocal2.get());
    }

}
