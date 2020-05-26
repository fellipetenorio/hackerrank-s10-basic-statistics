package d0;

import java.util.Scanner;

public class Q2WeightedMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Long.parseLong(tokens[i]);
        }

        s = scanner.nextLine();
        tokens = s.split(" ");
        long[] w = new long[size];
        for (int i = 0; i < size; i++) {
            w[i] = Long.parseLong(tokens[i]);
        }

        solve(size, numbers, w);
    }

    private static void solve(int size, long[] numbers, long[] weights) {
        double w = 0d;
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            long l = numbers[i];
            long weight = weights[i];

            sum += l*weight;
            w += weight;
        }

        System.out.printf("%5f", sum/w);
    }
}
