package arrays;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        int[] arr2 = {0, 1, 2, 3, 4};
        int[][] arr2D = {{11, 12}, {13, 14}};
        int[][] arr2D2 = {{11, 12}, {13, 14}};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
