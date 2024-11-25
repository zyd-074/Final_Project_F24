package Vanier;
import java.util.Scanner;

public class Average {
    //Data Field
    private int[] data = new int[5];
    private double mean;

    //Create Scanner to let user input data
    Scanner user = new Scanner(System.in);

    /**
     * The constructor
     */
    public Average() {
        for (int num = 0; num < 5; num++) {
            System.out.print("Score number " + (num+1) + ": ");
            this.data[num] = user.nextInt();
            user.nextLine();
        }
    }

    /**
     * The calculate Mean Method <p>
     * Will calculate the Average of the scores entered by the User
     */
    public void calculateMean() {
        for (int num = 0; num < this.data.length; num++) {
            this.mean += this.data[num];
        }
        this.mean /= this.data.length;
    }

    /**
     * The selectionSort Method <p>
     * Will rearrange the scores from highest to lowest
     */
    public  void selectionSort() {
        for (int num1 = 0; num1 < this.data.length; num1++) {
            int maxIndex = num1;
            for (int num2 = num1 + 1; num2 < this.data.length; num2++) {
                if (this.data[num2] > this.data[maxIndex]) {
                    maxIndex = num2;
                }
            }
            int temp = this.data[num1];
            this.data[num1] = this.data[maxIndex];
            this.data[maxIndex] = temp;
        }
    }

    /**
     * The toString Method
     * @return A string which shows the both the scores in order and the average
     */
    public String toString() {
        String string = "The scores in order : %s \nThe average score is : %.2f";
        String scores = String.valueOf(this.data[0]);
        for (int num = 1; num < 5; num++) {
            scores = scores + ", " + this.data[num];
        }
        return String.format(string, scores, this.mean);
    }

}
