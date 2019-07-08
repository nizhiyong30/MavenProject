package algorithm.util;

import java.util.Random;

public class CommonUtils {
    public static int[] generateRandomArray(int lenght) {
        int [] array = new int[lenght];
        Random random = new Random();
        for (int i = 0; i < lenght; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int [] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
    }
}
