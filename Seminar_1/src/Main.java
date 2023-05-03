import java.util.ArrayList;
import java.util.Scanner;

/*
1. Вычислить n-ое треугольного число (сумма чисел от 1 до n)
2. Вычислить n! (произведение чисел от 1 до n)
3. Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)
4. Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)
* Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
  например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
  Предложить хотя бы одно решение или сообщить, что его нет.
*/
public class Main {
    public static void main(String[] args) {
//        System.out.println(task1(15));
//        System.out.println(task2(5));
//        task3();
//        task4();
//        taskStar();
    }

    static int task1(int num) {
        int res = num * (num + 1) / 2;
        return res;
    }

    static int task2(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    static void task3() {
        for (int i = 2; i <= 1000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    static void task4() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int first_num = input.nextInt();
        System.out.println("Введите второе число: ");
        int second_num = input.nextInt();
        System.out.println("Какое действие нужно произвести: ");
        String sigh = input.next();
        switch (sigh) {
            case "+":
                System.out.println(first_num + second_num);
                break;
            case "-":
                System.out.println(first_num - second_num);
                break;
            case "*":
                System.out.println(first_num * second_num);
                break;
            case "/":
                System.out.println(first_num / second_num);
                break;
            default:
                System.out.println("Некорректный ввод!");
        }
        input.close();
    }
}