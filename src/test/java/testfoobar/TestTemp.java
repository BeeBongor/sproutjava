package testfoobar;

import org.junit.jupiter.api.Test;

public class TestTemp {

    ThreadLocal<Integer> a = new ThreadLocal<>();

    @Test
    public void test(){
        ZeroEvenOdd fooBar = new ZeroEvenOdd(20);
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.zero(new FooPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        String t ="<root>test</root>";
//        t.matches()

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.even(new FooPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.odd(new FooPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) throws InterruptedException {
        final FooBar fooBar = new FooBar(3);

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.foo(new FooPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.foo(new FooPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.bar(new BarPrint());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();

    }

    class Temp implements Runnable{
        public void run() {

        }
    }
}
