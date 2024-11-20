package Vanier;

public class AverageDrive {
    public static void main(String[] args) {
        Average result = new Average();

        result.selectionSort();
        result.calculateMean();

        String display = result.toString();
        System.out.println(display);
    }
}
