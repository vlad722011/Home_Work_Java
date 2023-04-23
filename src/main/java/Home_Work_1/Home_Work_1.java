package Home_Work_1;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Home_Work_1 {
    public static void main(String[] args) {

        System.out.println("Задача №1");
        int[] arr = ex1(5, 7);
        System.out.println(Arrays.toString(arr));

        System.out.println("Задача №1, второй вариант решения.");
        int[] array = ex1_1(5, 7);
        System.out.println(Arrays.toString(array));

        System.out.println("Задача №2");
        ex2();

        System.out.println("Задача №3");
        ex3(7);

        System.out.println("Задача №4");
        ex4();

        System.out.println("Задача №5");
        int[] arrEx5 = {3, 2, 2, 3, 5, 6, 6, 7, 957, -112, 817, 0, 94};
        System.out.println(Arrays.toString(arrEx5));
        int n = 3;
        ex5(arrEx5, n);
    }

    // Задача 1.
    // Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
    // одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

    // Вариант решения через цикл For
    private static int[] ex1(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    // Вариант решения, используя коллекцию Arrays
    private static int[] ex1_1(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    // Задача 2.
    // Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

    private static void ex2() {
        int[] arr = {3, 2, 2, 3, 5, 6, 6, 7, 957, -112, 817, 0, 94};
        System.out.println(Arrays.toString(arr));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.printf("Максимальный элемент массива = %d.%n", max);
        System.out.printf("Минимальный элемент массива = %d.%n", min);
    }

    // Задача 3.
    // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    private static void ex3(int len) {
        char[][] matrix = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    matrix[i][j] = '*';
                }
                if (j == len - 1 - i) {
                    matrix[i][j] = '*';
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    Задача 4.
    В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
    "Доброе утро, <Имя>!", если время от 05:00 до 11:59
    "Добрый день, <Имя>!", если время от 12:00 до 17:59;
    "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    */

    private static void ex4() {
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LocalDateTime time = LocalDateTime.now();
        int hours = time.getHour();

        if (hours >= 5 && hours < 12) {
            System.out.printf("Доброе утро, %s!%n", str);
        } else if (hours >= 12 && hours < 18) {
            System.out.printf("Добрый день, %s!%n", str);
        } else if (hours >= 18 && hours < 23) {
            System.out.printf("Добрый вечер, %s!%n", str);
        } else
            System.out.printf("Доброй ночи, %s!%n", str);
    }

    // Задача 5.**
    // Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
    // на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными
    // массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.

    private static void ex5(int []arr, int n) {
        while (n > 0) {
            int temp = 0;
            int indexEnd = arr.length - 1;
            for (int i = arr.length - 1; i > 0; i--) {
                temp = arr[indexEnd];
                arr[indexEnd] = arr[indexEnd - 1];
                arr[indexEnd - 1] = temp;
                indexEnd--;
            }
            n--;
        }
        System.out.println(Arrays.toString(arr));
    }

}
