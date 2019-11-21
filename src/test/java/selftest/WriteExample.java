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
        //���ݺܴ�Ҫʹ�ô����ഢ��
        BigInteger[][] dp = new BigInteger[x + 1][y + 1];
        for (int i = 1; i <= n; i++) {
            int xx = sc.nextInt();
            int yy = sc.nextInt();
            arr[xx][yy] = 1;
            //��boss�ĸ���ֱ�ӳ�ʼ��Ϊ0
            dp[xx][yy] = BigInteger.ZERO;
        }
        //��СϺֻ�������ߵ����긳ֵΪ1����Ϊ��ֻ�������ߣ�����ֻ��һ�ַ���
        for (int i = x - 1; i >= 0; i--) {
            //���������û��boss�����ܸ�ֵΪ1
            if (arr[i][y] == 0)
                dp[i][y] = BigInteger.ONE;
                //���������bossʱ����Ϊֻ�������ߣ�֮ǰ�ĵ㶼��boss��ס�ˣ����Ժ������е����궼��ֵΪ0
            else {
                for (int ii = i - 1; ii >= 0; ii--)
                    dp[ii][y] = BigInteger.ZERO;
                break;
            }
        }
        //��СϺֻ�������ߵ����긳ֵΪ1����Ϊ��ֻ�������ߣ�����ֻ��һ�ַ���
        for (int j = y - 1; j >= 0; j--) {
            //���������û��boss�����ܸ�ֵΪ1
            if (arr[x][j] == 0)
                dp[x][j] = BigInteger.ONE;
                //���������bossʱ����Ϊֻ�������ߣ�֮ǰ�ĵ㶼��boss��ס�ˣ����Ժ������е����궼��ֵΪ0
            else {
                for (int jj = j - 1; jj >= 0; jj--)
                    dp[x][jj] = BigInteger.ZERO;
                break;
            }
        }
        //��ÿһ������dp[x][y]���߷�����dp[x+1][y]+dp[x][y+1]
        for (int i = x - 1; i >= 0; i--)
            for (int j = y - 1; j >= 0; j--) {
                if (arr[i][j] == 0)
                    dp[i][j] = dp[i + 1][j].add(dp[i][j + 1]);
            }
        System.out.println(dp[0][0].toString());
    }

}
