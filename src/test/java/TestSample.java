import classobject.SubClass;
import multithread.Consumer;

public class TestSample {

    public static void main(String[] args) {
        int RUNNING    = -1 <<  (Integer.SIZE - 3);
        System.out.println(Integer.toBinaryString(-1));//－1的补码为11111111 按位取反+1
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(RUNNING);

        System.out.println(SubClass.value);
//        Class.forName()
//        ClassLoader.getSystemClassLoader().loadClass()
    }
}
