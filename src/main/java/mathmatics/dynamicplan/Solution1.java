package mathmatics.dynamicplan;

/**
 * Created by dengmingliang on 2020/4/23
 */
public class Solution1 {
  public int waysToChange(int n) {
    if (n == 0) {
      return 0;
    }
    if (n < 5 && n > 0) {
      return 0;
    }
    return waysToChange25();
  }

  public static Long waysToChangeAnumber(int number) {
    int count25 = number / 25;
    return (long) count25;
  }

  public static int waysToChange25() {
    return waysToChange10() * waysToChange10() * waysToChange5() / 2;
  }

  public static int waysToChange5() {
    return 2;
  }

  public static int waysToChange10() {
    return 4;
  }

  public static int waysToChange1() {
    return 1;
  }

}
