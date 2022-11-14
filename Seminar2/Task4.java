package Seminar2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String customString;
        while(true) {
            System.out.println("Введите строку любых символов: ");
            customString = scan.nextLine();
            try {
                NoMoreEmptyStrings(customString);
                break;
            } catch (Exception ex) {
                System.out.println(ex);                
            }
        }
        System.out.println("String OK!");
        scan.close();
    }

    public static void NoMoreEmptyStrings(String str) throws Exception {
        if (str.isEmpty()) 
            throw new Exception("Пустые строки вводить нельзя!");
    }
}
