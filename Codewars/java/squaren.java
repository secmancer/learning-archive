package codewars;

public class squaren
 {
  public static int squareSum(int[] n)
  {
    int total = 0;
    for (int i = 0; i < n.length; i++) {
      total += Math.pow(n[i], 2);
    }
    return total;
  }
 }
