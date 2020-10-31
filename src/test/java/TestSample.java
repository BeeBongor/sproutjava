import classobject.SubClass;
import multithread.Consumer;
import org.junit.jupiter.api.Test;

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
        int i = -5;
        System.out.println(i+"");
        TestSample testSample = new TestSample();
        System.out.println(testSample.reverse(-2147483648));
    }

    public int reverse(int x) {
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            rev = rev*10+pop;
            x = x/10;
        }
        return rev;
    }

    @Test
    public void test(){
        int n = 200 - 1;
        System.out.println(n>>>1);
        n |= n >>> 1;

        System.out.println(n);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);


        int[] i = new int[10];
        System.out.println(i.length);

    }


}
