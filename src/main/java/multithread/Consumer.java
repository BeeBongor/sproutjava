package multithread;

public class Consumer extends Thread {

    MyStack myStack;

    String consumerName;

    public Consumer(MyStack stack,String name){
        super(name);
        this.myStack = stack;
        this.consumerName = name;
    }

    @Override
    public void run(){
        while(true) {
            Object result = myStack.pop();
            System.out.println(consumerName + "µ¯³ö£º" + result.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
