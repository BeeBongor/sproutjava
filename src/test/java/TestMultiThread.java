import multithread.Consumer;
import multithread.MyStack;
import multithread.Producer;

public class TestMultiThread {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();


        new Producer(myStack, "������1").start();
        new Producer(myStack, "������2").start();
        new Consumer(myStack, "������1" ).start();
        new Consumer(myStack, "������2" ).start();
        new Consumer(myStack, "������3" ).start();

    }
}
