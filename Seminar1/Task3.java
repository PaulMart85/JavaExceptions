package Seminar1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, -5},
              secondArray = {2, -5, 0};
        
        System.out.println(Arrays.toString(substractArrays(firstArray, secondArray)));

        // если длины не равны
        firstArray = new int[]{1, 2};
        System.out.println(Arrays.toString(substractArrays(firstArray, secondArray)));
        
    }

    public static int[] substractArrays(int[] firstArray, int[] secondArray) {
        
        if (firstArray.length != secondArray.length) 
            throw new RuntimeException("Arrays's lengths not equal.");
        
        int len = firstArray.length;
        int[] resArray = new int[len];
        for (int i = 0; i < len; i++)
            resArray[i] = firstArray[i] - secondArray[i];

        return resArray;
    }
}
