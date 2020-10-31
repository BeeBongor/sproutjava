package arithmatics;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author dengmingliang
 * @Description
 * @ClassName Solution
 * @Date 2019/12/11 9:04 下午
 */
class Solution {
    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        System.out.print("转换后的二进制倒序");
        for (int m = 0; m < l; m++) {
            System.out.print(d[m] + "");
        }
        System.out.println();
        for (p = 1; p <= l / 2; ++p) {
            int i;
            boolean ok = true;
            for (i = l - 1; i >= p; --i) {
//                System.out.println("当前 i "+i);
//                System.out.println("当前 i-p "+(i-p));
                if (d[i] != d[i - p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }


    static int solution2(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <= l / 2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static int binaryToDecimal(int binaryNumber) {

        int decimal = 0;
        int p = 0;
        while (true) {

            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
                decimal += temp * Math.pow(2, p);
                binaryNumber = binaryNumber / 10;
                p++;
            }
        }
        return decimal;
    }

    public static int solution3(int[] X, int[] Y) {
        // write your code in Java SE 8
        if (X.length != Y.length) {
            throw new IllegalArgumentException("Input is wrong,The two arrays don't have equal length");
        }

        for (int i = X.length - 1; i < X.length; i--) {
            for (int j = 0; j < i; j++) {
                if (X[j] < 0 || X[j] > 1000000000) {
                    throw new IllegalArgumentException("Input is more than the maximum value or less than the minimum value");
                }
                if (X[j] > X[j + 1]) {
                    int temp = X[j + 1];
                    X[j + 1] = X[j];
                    X[j] = temp;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < X.length - 1; i++) {
            int temp = Math.abs(X[i] - X[i + 1]);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        int t[] = new int[]{1, 8, 7, 3, 4, 1, 8};
//        int y[] = new int[]{1, 8, 7, 3, 4, 1, 8};
//
//        int m[] = new int[]{6, 10, 1, 4, 3};
        int m[] = new int[]{1, 8, 7, 3, 4, 1, 8};
        int y[] = new int[]{4, 5, 1, 3, 1, 1, 1};
        int q = 1000000000;
//        System.out.println(solution3(t, y));
        System.out.println(solution3(m, y));
    }

    public int solution2(int[] X, int[] Y) {
        if (X == null || X.length < 2 || X.length != Y.length) {
            return 0;
        }
        int len = X.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (X[i] < 0 || X[i] > 1000000000) {
                throw new IllegalArgumentException("Input is more than the maximum value or less than the minimum value");
            }
            min = Math.min(min, X[i]);
            max = Math.max(max, X[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(X[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], X[i]) : X[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], X[i]) : X[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len) {
            if (hasNum[i++]) { //找到第一个不为空的桶
                lastMax = maxs[i - 1];
                break;
            }
        }
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //使用long类型是为了防止相乘时溢出
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

//    class Resouce extends Thread {
//
//        int val = 0;
//
//        int status = 0;
//
//        public Resouce(int val) {
//            this.val = val;
//        }
//
//        @Override
//        public void run() {
//            status =
//        }
//    }


    public int solution3(int[] A, int X, int Y, int Z) {
        int t = 0;
        // write your code in Java SE 8
        Semaphore semaphore = new Semaphore(3);
        int result = 0;
        int XinUse = 0;
        int YinUse = 0;
        int ZinUse = 0;
        int waitTime = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < X && XinUse == 0) {
                X -= A[i];
                XinUse = A[i];
            } else if (A[i] < Y && YinUse == 0) {
                Y -= A[i];
                YinUse = A[i];
            } else if (A[i] < Z && ZinUse == 0) {
                Z -= A[i];
                ZinUse = A[i];
            } else if(XinUse!=0){
                result = -1;
                break;
            }
        }
        return result;
    }

}