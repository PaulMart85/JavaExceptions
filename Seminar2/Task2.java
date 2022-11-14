package Seminar2;

public class Task2 {
    public static void main(String[] args) {
        someMeth(new int[]{1, 2, 3, -5, 8, -1, 2, 7, -4, 62});
        //someMeth(null);
        //someMeth(new int[]{1, 2, 3, -5});
    }

    public static void someMeth(int[] intArray) {
        // в данном алгоритме обрабатывается unchecked исключение ArithmeticException,
        // при этом с ним ничего не делается кроме вывода информации о нем, что и без
        // того сделает JVM. 
        // Возможные другие исключения, именно ArrayIndexOutOfBoundsException
        // и NullPointerException также являются unchecked.
        // Похоже в этом коде не предполагается что-либо делать с этими исключениями
        // помимо простого сообщения о них, то код предлагаю модифицировать, убрав
        // блок try-catch. Таким образом, Java сама сообщит об ArithmeticException, 
        // а также других unchecked исключениях, указанных выше
        
        // try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        //  } catch (ArithmeticException e) {
        //     System.out.println("Catching exception: " + e);
        //  }
         
    }

     

}
