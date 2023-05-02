package Home_Work_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Задача 3. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class EightQueens {

    // Создаем доску размером 8 на 8. Доска представляет собой двумерный массив, заполненный нулями.
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];


    public static void main(String[] args) {
        System.out.println("Решение задачи 3.");
        System.out.println("Одним из вариантов решения задачи, будут ферзи расположенные на полях:");
        solveQueen(0);
    }

    // Метод, отвечающий за установку ферзя на шахматную доску.
    // Поле, на которое установлен ферзь - маркируем значением минус 1.
    // "Битые поля" после установки ферзя на поле маркируем значением 1.
    public static void setQueen(int indexRow, int indexCol) {
        int x;
        for (x = 0; x < BOARD_SIZE; x++) {
            board[x][indexCol] += 1;
            board[indexRow][x] += 1;
            if ((indexRow + indexCol - x) >= 0 && (indexRow + indexCol - x) < 8) {
                board[indexRow + indexCol - x][x] += 1;
            }
            if ((indexRow - indexCol + x) >= 0 && (indexRow - indexCol + x) < 8) {
                board[indexRow - indexCol + x][x] += 1;
            }
            board[indexRow][indexCol] = -1;
        }
    }

    // Метод, удаляющий с доски ферзя, если положение оказалось не правильным.
    // После удаления ферзя с доски, "битые поля" переводим в статус не "битых", так как ферзь
    // снят с доски. Возвращаем значение для этих полей в исходное состояние.
    // То есть маркируем значением 0.
    public static void removeQueen(int indexRow, int indexCol) {
        int x;
        for (x = 0; x < BOARD_SIZE; x++) {
            board[x][indexCol] -= 1;
            board[indexRow][x] -= 1;
            if ((indexRow + indexCol - x) > 0 && (indexRow + indexCol - x) < 8) {
                board[indexRow + indexCol - x][x] -= 1;
            }
            if ((indexRow - indexCol + x) > 0 && (indexRow - indexCol + x) < 8) {
                board[indexRow - indexCol + x][x] -= 1;
            }
            board[indexRow][indexCol] = 0;
        }
    }

    // Метод отвечающий за вывод найденного решения на печать.
    // Вывод осуществляем в привычном для пользователя формате,
    // то есть так, как поля помечены у обычной шахматной доски.
    public static void printPositionQueen() {
        List<String> rows = new ArrayList<>();
        String[] row = {"a", "b", "c", "d", "e", "f", "g", "h"};
        rows.addAll(Arrays.asList(row));
        List<String> field = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == -1) {
                    String boardField = rows.get(j) + String.valueOf(i + 1);
                    field.add(boardField);
                }
            }
        }
        System.out.println(field.toString());
    }

    // Метод, отвечающий за нахождение правильного решения.
    // Использует рекурсию.
    public static void solveQueen(int indexRow) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[indexRow][j] == 0) {
                setQueen(indexRow, j);
                if (indexRow == 7) {
                    printPositionQueen();
                } else {
                    solveQueen(indexRow + 1);
                    removeQueen(indexRow, j);
                }
            }
        }
    }
}


