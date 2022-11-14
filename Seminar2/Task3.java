package Seminar2;

// import java.io.FileNotFoundException;

public class Task3 {
    // здесь выброс Exception уберем, т.к. выше main пробрасывать некуда.
    public static void main(String[] args) /*throws Exception*/  {
        // эти примитивные переменные вынесены за блок try, т.к 
        // исключения никогда не выбросят.
        int a = 90; // здесь предполагаются пользовательские данные
        int b = 3;
        // b = 0; // ArithmeticException

        // далее в блоке try предполагается изменение констант пользователем,
        // тогда возможны исключения в операции деления (в случае b = 0),
        // в методе printSum (в случае хотя бы одного из аргументов со значением null),
        // в массиве abc (в случае указания индекса за пределами размера массива)
        try {
            System.out.println(a / b);
            printSum(23, 234);
            // printSum(23, null); // NPE
            int[] abc = { 1, 2 };
            abc[1] = 9;
            //abc[3] = 9; // IndexOutOfBoundsException
        } 
        
        // исключение Throwable охватывает все возможные исключения. Если оно 
        // будет следовать первым среди catch, то последующие типы исключений,
        // которые ВСЕ являются наследниками Throwable, достигнуты не будут. 
        // Нам интересно понимание того, в каком месте произошло исключение,
        // поэтому в данной ситуации catch-Throwable можно удалить или, на случай,
        // переместить его в конец обработки всех предполагаемых исключений.

        // Далее будем перехватывать предполагаемые исключения по порядку. Порядок
        // впрочем не обязателен.
        catch (ArithmeticException ex) {
            System.out.println("Деление на ноль. Значение b = 0!");
        } catch (NullPointerException ex) {
            System.out.println("В printSum: указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив abc выходит за пределы своего размера!");
        } catch (Throwable ex) { // если мы что-то не учли
            System.out.println("Что-то пошло не так... " + ex);
        }
    }
     
     // в данном методе работа с файлами не предполагается, и выброс нижеследующего
     // исключения излишен - его можно опустить.
     public static void printSum(Integer a, Integer b) /*throws FileNotFoundException*/ {
        System.out.println(a + b);
     }
     


}
