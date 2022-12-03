public class sumarray {
    public static double sum(double[] numbers) {
        double total = 0.0;
        for (double num : numbers) total += num;
        return total;
    }
}
