package testfoobar;

class FooBar {
    private int n;
    private volatile boolean finish=false;
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while(finish){
                this.wait();
            }
            this.notify();
            printFoo.run();
            finish=true;
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!finish){
                this.wait();
            }
            this.notify();
            printBar.run();
            finish=false;
        }
    }
}
