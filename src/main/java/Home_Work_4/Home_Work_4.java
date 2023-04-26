package Home_Work_4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Home_Work_4 {
    public static void main(String[] args) {
        System.out.println("Решение задачи 1.");
        ex1();
        System.out.println();
        System.out.println("Решение задачи 2.");
        ex2();
    }

    // 1. Реализовать консольное приложение, которое:
    //   Принимает от пользователя и “запоминает” строки.
    //   Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
    //   Если введено revert, удаляет предыдущую введенную строку из памяти.
    private static void ex1() {
        LinkedList<String> stringsList = new LinkedList<>();
        Scanner console = new Scanner(System.in);
        System.out.println("Введите строку:");
        while (console.hasNext()) {
            String inputString = console.nextLine();
            if (inputString.trim().length() == 0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("print")) {
                printAllFromLastToFirstString(stringsList);
                break;
            }
            if (inputString.equalsIgnoreCase("revert")) {
                removePreviousString(stringsList);
                continue;
            }
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            }
            if (inputString.equalsIgnoreCase("стоп")) {
                break;
            } else {
                stringsList.add(inputString);
            }
        }
        System.out.println("Для удобства контроля выведем текущее сосотояние списка ниже:");
        System.out.println(stringsList.toString());
    }

    private static void removePreviousString(LinkedList<String> stringsList) {
        int index = stringsList.size() - 1;
        stringsList.remove(index);
    }

    private static void printAllFromLastToFirstString(LinkedList<String> stringsList) {
        for (int i = stringsList.size() - 1; i >= 0; i--) {
            System.out.println(stringsList.get(i));
        }
    }

    // 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    private static void ex2() {
        LinkedList<String> stringsList = new LinkedList<>();
        Collections.addAll(stringsList, "first", "second", "third", "four", "five", "six", "seven");
        System.out.println("Входящий список LinkedList:");
        System.out.println(stringsList.toString());
        for (int i = 0; i < stringsList.size() / 2; i++) {
            int index = i;
            String left = stringsList.get(i);
            String right = stringsList.get(stringsList.size() - i - 1);
            stringsList.remove(index);
            i--;
            stringsList.add(index, right);
            i++;
            stringsList.remove(stringsList.size() - i - 1);
            i--;
            stringsList.add(stringsList.size() - i - 1, left);
            i++;
        }
        System.out.println("Перевернутый список LinkedList:");
        System.out.println(stringsList.toString());
    }
}
