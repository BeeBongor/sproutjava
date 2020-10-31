package spring;

/**
 * @author dengmingliang
 * @Description
 * @ClassName SuperClass
 * @Date 2019/12/6 4:04 下午
 */
public abstract class SuperClass extends SSuperClass{

    public static final String test = "hheeda";

    public abstract void test6();

    @Override
    public void test1(){
        System.out.println("super test");
//        test2();
    }

    @Override
    public void test2(){

        double f = 0.5;
        float t = 1.9f;
        char m = '\u0639';
        Object o = 'f';
        String s = "hello,world\0";
        Double d = 100d;
        System.out.println("super test");
    }
}
