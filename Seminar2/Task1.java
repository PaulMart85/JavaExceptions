package Seminar2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Вы ввели: " + ioNumber());
    }

    public static float ioNumber() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите вещественное число: ");
        float sGet;
        while(true) {
            try {
                sGet = Float.parseFloat(scan.nextLine());
                break;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Это не вещественное число. Попробуйте еще раз: ");
            }
        }
        scan.close();

        return sGet;
    }
}