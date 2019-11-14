package multithread;

import java.util.Stack;

public class MyStack<E> extends Stack {

    public int elementCount;

    @Override
    public synchronized Object push(Object object) {
        while (elementCount >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        Object result = super.push(object);
        this.elementCount = super.elementCount;
        return result;
    }


    @Override
    public synchronized Object pop() {
        while (elementCount == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        Object result =super.pop();
        elementCount = super.elementCount;
        return result;
    }

}
