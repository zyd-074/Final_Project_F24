package Vanier;

public class AverageDrive {
    public static void main(String[] args) {
        //Create Object
        Average result = new Average();

        //Call method to operate
        result.selectionSort();
        result.calculateMean();

        //Create String to display result
        String display = result.toString();
        System.out.println(display);
    }
}
