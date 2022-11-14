package Seminar1;

public class Task1 {
    public static void main(String[] args) {
        // System.out.println(sumNumbers(10, null));
        // System.out.println(sumArray(new int[]{1, 2, 3}));
        // System.out.println(devideNumbers(2,0));
    }

    public static int sumNumbers(Integer a, Integer b) {
        return a + b;
    }

    public static int sumArray(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length + 1; i++) {
            sum += array[i];            
        }

        return sum;
    } 

    public static double devideNumbers(double a, double b) {
        return a / b;
    }
}