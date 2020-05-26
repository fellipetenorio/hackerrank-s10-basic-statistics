package d1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1Quartiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        solve(size, numbers);
    }

    private static void solve(int size, int[] numbers) {
        int q1;
        int q2;
        int q3;

        Arrays.sort(numbers);

        // q1
        int from = size / 2;
        int[] q1N = Arrays.copyOfRange(numbers, 0, from);
        if (size % 2 != 0)
            from ++;
        int[] q3N = Arrays.copyOfRange(numbers, from, size);
        q1 = median(q1N.length, q1N);
        q2 = median(size, numbers);
        q3 = median(q3N.length, q3N);


        System.out.printf("%d\n", q1);
        System.out.printf("%d\n", q2);
        System.out.printf("%d\n", q3);
    }

    private static int median(int size, int[] numbers) {
        int median = numbers[size/2];
        if (size % 2 == 0) {
            median = (median + numbers[size/2 - 1])/2;
        }
        return median;
    }
}
