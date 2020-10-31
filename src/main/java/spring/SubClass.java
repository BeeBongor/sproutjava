package spring;

/**
 * @author dengmingliang
 * @Description
 * @ClassName SubClass
 * @Date 2019/12/6 4:04 下午
 */
public class SubClass  extends  SuperClass{

    public int tem;

    private int tem1;

    public final int tem2=1;

    public String tem3;

    public final String temp4=1+"";

    @Override
    public void test6() {
        System.out.println("heheda");
    }

    @Override
    public void test2(){
        System.out.println("subclass 2");
    }

    public static void main(String[] args) {
        SSuperClass superClass = new SubClass();
        superClass.test();
    }
}
