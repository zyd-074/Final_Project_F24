package Vanier;
import java.util.Scanner;

public class Average {
    private int[] data = new int[5];
    private double mean;

    Scanner user = new Scanner(System.in);

    public Average() {
        for (int num = 0; num < 5; num++) {
            System.out.print("Score number " + (num+1) + ": ");
            this.data[num] = user.nextInt();
            user.nextLine();
        }
    }

    public void calculateMean() {
        for (int num = 0; num < 5; num++) {
            this.mean += this.data[num];
        }
        this.mean /= this.data.length;
    }

    public  void selectionSort() {
        for (int num1 = 0; num1 < this.data.length; num1++) {
            int minIndex = num1;
            for (int num2 = num1 + 1; num2 < this.data.length; num2++) {
                if (this.data[num2] < this.data[minIndex]) {
                    minIndex = num2;
                }
            }
            int temp = this.data[num1];
            this.data[num1] = this.data[minIndex];
            this.data[minIndex] = temp;
        }
    }

    public String toString() {
        String string = "The scores in order : %s \nThe average score is : %.2f";
        String scores = String.valueOf(this.data[0]);
        for (int num = 1; num < 5; num++) {
            scores = scores + ", " + this.data[num];
        }
        return String.format(string, scores, this.mean);
    }

}
