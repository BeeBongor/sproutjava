import multithread.Consumer;
import multithread.MyStack;
import multithread.Producer;

public class TestMultiThread {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();


        new Producer(myStack, "生产者1").start();
        new Producer(myStack, "生产者2").start();
        new Consumer(myStack, "消费者1" ).start();
        new Consumer(myStack, "消费者2" ).start();
        new Consumer(myStack, "消费者3" ).start();

    }
}
