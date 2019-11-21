package testfoobar;

import java.util.function.IntConsumer;

public class FooPrint implements Runnable, IntConsumer {
    public void run() {
        System.out.println("fooPrint");
    }

    @Override
    public void accept(int value) {
        System.out.println(value);
    }
}
