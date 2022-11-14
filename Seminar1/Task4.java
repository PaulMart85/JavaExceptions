package Seminar1;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, -5},
        secondArray = {2, -5, 4};
  
        System.out.println(Arrays.toString(divisionArrays(firstArray, secondArray)));

        // если длины не равны
        firstArray = new int[]{1, 2};
        System.out.println(Arrays.toString(divisionArrays(firstArray, secondArray)));        

        // если деление на 0
        secondArray = new int[]{-4, 0};
        System.out.println(Arrays.toString(divisionArrays(firstArray, secondArray)));        
    }

    public static double[] divisionArrays(int[] firstArray, int[] secondArray) {
        
        if (firstArray.length != secondArray.length) 
            throw new RuntimeException("Arrays's lengths not equal.");
        
        int len = firstArray.length;
        double[] resArray = new double[len];
        for (int i = 0; i < len; i++) {
            if (secondArray[i] == 0) 
                throw new RuntimeException(String.format("Division by zero: secondArray[%d] equals 0.", i));
            resArray[i] = (double)firstArray[i] / (double)secondArray[i];
        }

        return resArray;
    }
}
