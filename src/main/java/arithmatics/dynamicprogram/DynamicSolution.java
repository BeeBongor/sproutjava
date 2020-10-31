package arithmatics.dynamicprogram;

import org.junit.Test;

/**
 * @author dengmingliang
 * @Description
 * @ClassName DynamicSolution
 * @Date 2019/12/13 5:38 下午
 */
public class DynamicSolution {

    //数组中的不相邻的数累加的最大值
    public int countMax(int[] t) {
        int[] countArray = new int[t.length];
        countArray[0] = t[0];
        countArray[1] = t[1];
        for (int i = 2; i < t.length; i++) {
            countArray[i] = countArray[i - 2] + t[i] > countArray[i - 1] ? countArray[i - 2] + t[i] : countArray[i - 1];
        }
        return countArray[t.length - 1];
    }

    //递归写法
    public int recCountMax(int[] t, int i) {
        if (i == 0) {
            return t[i];
        } else if (i == 1) {
            return Math.max(t[0], t[1]);
        } else {
            int chooseThis = recCountMax(t, i - 2) + t[i];
            int dontChooseThis = recCountMax(t, i - 1);
            return Math.max(chooseThis, dontChooseThis);
        }
    }

    //找出数组中是否有累计值为i的数组序列
    public boolean findCount(int[] t, int sum, int i) {
        if (sum == 0) {
            return true;
        }
        if (i == 0) {
            return t[i] == sum;
        }
        return findCount(t, sum - t[i], i - 1) || findCount(t, sum, i - 1);
    }

    //找出数组中是否有累计值为i的数组序列,非递归写法
    public boolean findCount2(int[] t, int sum, int i) {
        boolean[][] dynamicProcess = new boolean[t.length][sum + 1];
        for (int row = 0; row < t.length; row++) {
            dynamicProcess[row][0] = true;
        }
        for (int column = 1; column < sum + 1; column++) {
            dynamicProcess[0][column] = false;
        }
        if (t[0] < sum) {
            dynamicProcess[0][t[0]] = true;
        }
        for (int row = 1; row < t.length; row++) {
            for (int column = 0; column < sum + 1; column++) {
                if (t[row] == column) {
                    dynamicProcess[row][column] = true;
                } else if (t[row] > column) {
                    dynamicProcess[row][column] = dynamicProcess[row - 1][column];
                } else {
                    dynamicProcess[row][column] = dynamicProcess[row - 1][column] || dynamicProcess[row - 1][column - t[row]];
                }
            }
        }
        //复杂度n*m
        return dynamicProcess[t.length - 1][sum];
    }


    //将A字符串转换成B字符串最快需要操作几次
    public int transferString(String word1, String word2) {
        int[][] p = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            p[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            p[0][j] = j;
        }

        for (int i = 1; i < word1.length() ; i++) {
            for (int j = 1; j < word2.length() ; j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    p[i][j] = p[i-1][j-1];
                }else {
                    p[i][j] = Math.min(Math.min(p[i-1][j]+1,p[i][j-1]+1),p[i-1][j-1]+1);
                }
            }
        }
        return p[word1.length()-1][word2.length()-1];
    }


    @Test
    public void test() {
        int[] t = new int[]{1, 2, 3, 4, 55, 2, 33, 29, 28, 11, 10};
        System.out.println(countMax(t));
        System.out.println(recCountMax(t, t.length - 1));
        int sum[] = {4, 5, 6, 200};
        for (int i : sum) {
            System.out.println(findCount(t, i, t.length - 1));
            System.out.println(findCount2(t, i, t.length - 1));
        }

        System.out.println(transferString("abcd","ddabced"));


    }
}
