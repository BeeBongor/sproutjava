import classobject.SubClass;
import multithread.Consumer;

public class TestSample {

    public static void main(String[] args) {
        int RUNNING    = -1 <<  (Integer.SIZE - 3);
        System.out.println(Integer.toBinaryString(-1));//��1�Ĳ���Ϊ11111111 ��λȡ��+1
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(RUNNING);

        System.out.println(SubClass.value);
//        Class.forName()
//        ClassLoader.getSystemClassLoader().loadClass()
    }
}
