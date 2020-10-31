package Arithmatic;

import org.junit.jupiter.api.Test;

/**
 * @author dengmingliang
 * @Description
 * @ClassName SomeSampleArithmatic
 * @Date 2019/11/27 8:14 下午
 */
public class CircleNumber {


    /**
     * 转为字符串方式判断是否是回文数
     * @param test
     */
    @Test
    public void testCircleNumber(int[] test){
        for(int x :test) {
            System.out.println(x);
            String toJudgeString = x + "";
            int length = toJudgeString.length();
            boolean result = true;
            for (int i = 0; i < length / 2; i++) {
                if (i <= length - i - 1) {
                    if (toJudgeString.charAt(i) == toJudgeString.charAt(length - i - 1)) {
                        continue;
                    } else {
                        System.out.println("is not a circle number");
                        result = false;
                        break;
                    }
                }
            }
            System.out.println(result);
        }

    }


    @Test
    public void test(){
        int[] x = {121,1221,12221,122,1222,12222,10,12222222,22222222};
//        testCircleNumber(x);

        System.out.println("_____________");
        long start = System.currentTimeMillis();
        for(int t :x) {
            System.out.println(t);
            circle3(t);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        for(int t :x) {
            circle2(t);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * StringBuilder的reverse功能
     * @param x
     */
    public void circle2(int x){
        System.out.println(x);
        StringBuilder t = new StringBuilder(x+"");
        String copy = t.toString();
//        System.out.println(t.reverse());
        if(!t.reverse().toString().equals(copy)){
            System.out.println("is not a circle number");
        }else{
            System.out.println("is a circle number");
        }
    }


    /**
     * 高位跟低位同时取0
     * @param x
     */
    public void circle3(int x){
        int div = 1;
        if(x<0) {
            System.out.println("is not a circle number");
            return;
        }
        while(x/div>0){
            div*=10;
        }
        div = div/10;
        int divRight = 1;
        while(div>=divRight*10){
            if(x/div!=(x%(divRight*10))/divRight){
                System.out.println("is not a circle number");
                break;
            }
            x = x/div;
            div = div/10;
            divRight = divRight*10;
        }
    }


}
