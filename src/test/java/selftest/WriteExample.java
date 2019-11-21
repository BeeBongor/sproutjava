package selftest;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Scanner;

public class WriteExample {

    public static void main(String[] args) {
        WriteExample writeExample = new WriteExample();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLong());
        }
//        scanner.nextLine()


//        writeExample.getCounts();
    }

    @Test
    public void getTotalRoads(int[][] arrays) {
        int[] destination = arrays[0];
        int result = getSingleCount(destination[0], destination[1], arrays);
        System.out.println(result);

    }

    private int getSingleCount(int i, int j, int[][] arrays) {
        if (i == 0 || j == 0) {
            return 1;
        }
        for (int[] temp : arrays) {
            if (i - 1 == temp[0] && j == temp[1]) {
                return getSingleCount(i, j - 1, arrays);
            } else if (i == temp[0] && j - 1 == temp[1]) {
                return getSingleCount(i - 1, j, arrays);
            }
        }
        return getSingleCount(i - 1, j, arrays) + getSingleCount(i, j - 1, arrays);
    }

    @Test
    public void test1() {
        int[][] array = new int[9][9];
        array[0] = new int[]{3, 3};
        array[1] = new int[]{2, 1};
        array[2] = new int[]{1, 1};
        getTotalRoads(array);
    }

    private void goNext() {
    }

    public void goStraight() {
    }

@Test
    public void test() {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[x + 1][y + 1];
        //数据很大，要使用大数类储存
        BigInteger[][] dp = new BigInteger[x + 1][y + 1];
        for (int i = 1; i <= n; i++) {
            int xx = sc.nextInt();
            int yy = sc.nextInt();
            arr[xx][yy] = 1;
            //有boss的格子直接初始化为0
            dp[xx][yy] = BigInteger.ZERO;
        }
        //给小虾只能往左走的坐标赋值为1，因为他只能往左走，所以只有一种方法
        for (int i = x - 1; i >= 0; i--) {
            //当坐标点上没有boss，才能赋值为1
            if (arr[i][y] == 0)
                dp[i][y] = BigInteger.ONE;
                //当坐标点有boss时，因为只能往左走，之前的点都被boss挡住了，所以后面所有的坐标都赋值为0
            else {
                for (int ii = i - 1; ii >= 0; ii--)
                    dp[ii][y] = BigInteger.ZERO;
                break;
            }
        }
        //给小虾只能往下走的坐标赋值为1，因为他只能往下走，所以只有一种方法
        for (int j = y - 1; j >= 0; j--) {
            //当坐标点上没有boss，才能赋值为1
            if (arr[x][j] == 0)
                dp[x][j] = BigInteger.ONE;
                //当坐标点有boss时，因为只能往下走，之前的点都被boss挡住了，所以后面所有的坐标都赋值为0
            else {
                for (int jj = j - 1; jj >= 0; jj--)
                    dp[x][jj] = BigInteger.ZERO;
                break;
            }
        }
        //到每一个坐标dp[x][y]的走法等于dp[x+1][y]+dp[x][y+1]
        for (int i = x - 1; i >= 0; i--)
            for (int j = y - 1; j >= 0; j--) {
                if (arr[i][j] == 0)
                    dp[i][j] = dp[i + 1][j].add(dp[i][j + 1]);
            }
        System.out.println(dp[0][0].toString());
    }

}
