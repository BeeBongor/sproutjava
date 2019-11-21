package temptest;

class Foo {

    volatile int i = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws Exception {
        if (i == 0) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i++;

        }
    }

    public void second(Runnable printSecond) throws Exception {
        while (i != 1) {
            this.wait();
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i++;

    }

    public void third(Runnable printThird) throws Exception {
        while (i != 2) {
            this.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        final Foo foo = new Foo();

    }
}
