package seminar1;
public class Homework {
public static void main(String[] args) {
    System.out.println("isSumBetween10And20: " + isSumBetween10And20(5, 15)); // true
    System.out.println("isSumBetween10And20: " + isSumBetween10And20(7, 15)); // false

    System.out.println("isPositive: " + isPositive(5)); // true
    System.out.println("isPositive: " + isPositive(-3)); // false

    System.out.println("isLeapYear: " + isLeapYear(1980));
    System.out.println("isLeapYear: " + isLeapYear(1978));

    printString("abcd", 5); // abcdabcdabcdabcdabcd

    createArray(5, 3);

    int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    task1(array);

    int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    task2(array2);

    int n = 5; // количество строк и столбцов в массиве
    int[][] arr = new int[n][n];
    task3(arr, n);

}

/**
 * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
 * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
 */
private static boolean isSumBetween10And20(int a, int b) {
    // проверить, что сумма a и b лежит между 10 и 20
    int sum = a + b;
    if (10 <= sum && sum <= 20) {
        return true;
    } else {
        return false;
    }
}

private static boolean isPositive(int x) {
    // проверить, что х положительное
    if (x > 0) {
        return true;
    }
    else {
        return false;
    }
}

private static void printString(String source, int repeat) {
    // напечатать строку source repeat раз
    for (int i = 0; i < repeat; i++) {
        System.out.print(source);
    }
}

private static boolean isLeapYear(int year) {
    // проверить, является ли год високосным. если да - return true
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        return true;
    }
    else {
        return false;
    }
}

private static int[] createArray(int len, int initalValue) {
    // должен вернуть массив длины len, каждое значение которого равно initialValue
    int[] array = new int[len];
    System.out.println();
    System.out.println();
    System.out.print("createArray: ");
    for (int i = 0; i < array.length; i++) {
        array[i] = initalValue;
        System.out.print(array[i] + " ");
    }
    return array;
}
private static void task1(int[] array) {
    System.out.println();
    System.out.print("Revert numbers: ");
    for (int i = 0; i < array.length; i++) {
        if (array[i] == 1) {
            array[i] = 0;
        }
        else {
            array[i] = 1;
        }
        System.out.print(array[i] + " ");
    }
}
private static void task2(int[] array) {
    System.out.println();
    System.out.print("Number < 6? Then x2: ");
    for (int i = 0; i < array.length; i++) {
        if (array[i] < 6) {
            array[i] *= 2;
        }
        System.out.print(array[i] + " ");
    }
}
private static void task3(int[][] arr, int n) {
    System.out.println();
    System.out.println();
    for (int i = 0; i < n; i++) {
        arr[i][i] = 1;
    }
    for (int i = 0; i < n; i++) {
        arr[i][n - i - 1] = 1;
    }
    for (int[] row : arr) {
        for (int i : row) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/**
 * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
 * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
 * 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
 * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). 
 * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
 * * Также заполнить элементы побочной диагонали
 */
}