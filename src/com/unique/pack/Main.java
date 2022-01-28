package com.unique.pack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calcUsersCash();
        printList();
        searchInArray();
    }

    private static void calcUsersCash() {
//        1) В банк положили s денег. Какой станет сумма вклада через n лет,
//        если процент 1,5% добавляется к сумме вклада ежемесячно. (сложный процент)
//        Написать метод который принимает 2 параметра - s, n и возвращает сумму денег на счету.
        System.out.println("Task 1.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите сумму вклада: ");
        int s = scanner.nextInt();
        System.out.print("Укажите срок вклада(лет): ");
        int n = scanner.nextInt();
        System.out.printf("К концу срока действия вклада сумма на вашем счету составит: %s.\n", compoundInterest(s, n));
        System.out.println("-----------------------------------------------------------------------");
    }

    private static double compoundInterest(int s, int n) {
        double percent = 0.015;
        return Math.round(s * Math.pow((1 + percent), n * 12) * 100) / 100.0;
//        и тут я понял, что в ДЗ с населением планеты в качестве коэфа брал не 0.1, а 10...и получил сотни лярдов -_-
    }

    private static void printList() {
//        2) Реализовать метод который вернет строку String, в которой через пробел все числа от 1 до 99
//        со следующими изменениями:
//        (!!!Сам метод не должен ничего печатать в консоль, он просто должен вернуть строку!!!)
//        - если число кратно 3 то вывести вместо него Hello
//        - если число кратно 5 то вывести вместо него World
//        - если число кратно и 3 и 5 то вывести вместо него HelloWorld
//        - иначе вывести просто само число
        System.out.println("Task 2.");
        System.out.println(createList());
        System.out.println("-----------------------------------------------------------------------");
    }

    private static StringBuilder createList() {
        StringBuilder list = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.append("Hello ");
            } else if (i % 3 == 0) {
                list.append("World ");
            } else if (i % 5 == 0) {
                list.append("HelloWorld ");
            } else {
                list.append(i).append(" ");
            }
        }
        list.deleteCharAt(list.length() - 1);
        return list;
    }

    private static void searchInArray() {
//        3*) Написать метод который ищет при помощи бинарного поиска есть ли число в отсортированном массиве.
//        Входящие параметры: массив и число.
//        (считаем что массива который нам передали отсортирован, проверять это не нужно)
        System.out.println("Task 3.");
        Scanner scanner = new Scanner(System.in);
        int[] array = {3, 14, 15, 18, 21, 55, 178, 278, 305};
        System.out.println("Имеется массив: " + Arrays.toString(array));
        System.out.println("Какое значение в этом массиве вы хотите найти?");
        int desiredValue = scanner.nextInt();
        int searchResultCell = binarySearch(array, desiredValue);
        if (searchResultCell == -1) {
            System.out.println("Искомое значение отсутсвует в указанном массиве.");
        } else {
            System.out.printf("Искомое значение находится в %s ячейке массива.", searchResultCell);
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    private static int binarySearch(int[] array, int desiredValue) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (desiredValue < array[middle]) {
                right = middle - 1;
            } else if (desiredValue > array[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}