package Seminar1;

public class Task2 {
    public static void main(String[] args) {
        // рабочий случай
        String[][] array = {{"1", "3", "5", "7", "-5"}, {"1", "8", "-3", "-1", "4"}};
        
        // 1. исключение с выходом за границы диапазона массива
        array = new String[][]{{"1", "3", "5", "7", "-5"}, {"1", "8", "-3", "-1"}};

        // 2. исключение с невозможностью обработки "нечислового" элемента(ов) массива
        array = new String[][]{{"1", "3", "5a", "7", "-5"}, {"1", "8", "-3", "-1", "4"}};
        // или даже число, но не целое
        array = new String[][]{{"1", "3", "5.0", "7", "-5"}, {"1", "8", "-3", "-1", "4"}};
        
        // 3. исключение NPE
        array = null;
        // или хотя бы один из элементов - null
        array = new String[][]{{"1", "3", null, "7", "-5"}, {"1", "8", "-3", "-1", "4"}};
        // или хотя бы один из элементов - пустая строка
        array = new String[][]{{"1", "3", "", "7", "-5"}, {"1", "8", "-3", "-1", "4"}};

        // 4. исключение в результате выхода числа (либо суммарно) за пределы 
        // допустимого диапазона int
        array = new String[][]{{"1", "3", "5000000000", "7", "-5"}, {"1", "8", "-3", "-1", "4"}};

        // 5. исключение в связи со входом пустого массива
        array = new String[][]{{},{}};

       
        System.out.println(sum2d(array));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
}
