package d0;

import java.util.Arrays;
import java.util.Scanner;

public class Q1MeanMedianMode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Long.parseLong(tokens[i]);
        }

        solve(size, numbers);
    }

    private static void solve(int size, long[] numbers) {
        double mean = 0d;
        double median;
        double mode = -1;
        int modeCount = 0;
        int winnerCount = 0;
        long previous = -1;

        Arrays.sort(numbers);

        for (long a: numbers) {
            if (a == previous) {
                modeCount++;
            } else {
                modeCount = 1;
            }

            if (modeCount > winnerCount) {
                mode = a;
                winnerCount = modeCount;
            }

            previous = a;
            mean += a;
        }

        median = numbers[size/2];
        if (size % 2 == 0) {
            median = (median + numbers[size/2 - 1])/2;
        }

        System.out.printf("%.1f\n", mean/size);
        System.out.printf("%.1f\n", median);
        System.out.printf("%.0f\n", mode);
    }
}
