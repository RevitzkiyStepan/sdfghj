package geekbrains.lesson_3_4_5;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int range = 100;
        for (int i = 10; i <= 30; i+=10) {
            playGame(i);
        }
        sc.close();
    }

    private static void playGame(int range){
        int number = (int) (Math.random() * range);
        while (true) {
            System.out.println("Ваша задача угадати число від 0 до " + range);
            int inputNumber = sc.nextInt();
            if (inputNumber == number) {
                System.out.println("Ви угадали");
                break;
            } else if (inputNumber > number) {
                System.out.println("Ваше число більше заданого");
            } else if (inputNumber < number) {
                System.out.println("Ваше число менше заданого");
            }
        }
    }
}
