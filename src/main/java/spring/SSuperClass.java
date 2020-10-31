package spring;

/**
 * @author dengmingliang
 * @Description
 * @ClassName SSuperClass
 * @Date 2019/12/6 4:06 下午
 */
public class SSuperClass  {
    public void test(){
        test1();
        test2();
        test3();
    }

    private void test3() {
        System.out.println("ss 3");
    }

    public void test1(){
        System.out.println("ss 1");
    }

    public void test2(){
        System.out.println("ss 2");
    }
}
