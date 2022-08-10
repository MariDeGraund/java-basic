import java.util.Arrays;

public class ArraySort {
    public static void arraySort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {21, 1, 5, 65, 33, 2, 11, 19, 41, 52};
        printArray(arr);
        long timeBegin = System.nanoTime();
        arraySort(arr);
        long timeEnd = System.nanoTime();
        System.out.println();
        System.out.println("Отсортированный массив по возрастанию: ");
        printArray(arr);
        System.out.println();
        System.out.println("Время выполнения: " + (timeEnd - timeBegin));

        int[] arr2 = {21, 1, 5, 65, 33, 2, 11, 19, 41, 52};
        printArray(arr2);
        long timeBegin2 = System.nanoTime();
        Arrays.sort(arr2);
        long timeEnd2 = System.nanoTime();
        System.out.println();
        System.out.println("Отсортированный массив по возрастанию: ");
        printArray(arr2);
        System.out.println();
        System.out.println("Время выполнения: " + (timeEnd2 - timeBegin2));
    }
}