package testfoobar;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private volatile int state = 0;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(state%2!=0){
                Thread.yield();
            }
            printNumber.accept(0);
            state++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < 2 * n; i+=2) {
            while(state%4!=1){
                Thread.yield();
            }
            printNumber.accept(i);
            state++;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= 2 * n; i+=2) {
            while(state%4!=3){
                Thread.yield();
            }
            printNumber.accept(i);
            state++;
        }
    }
}