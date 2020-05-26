package d1;

import java.util.Scanner;

public class Q2StandardDeviation {
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
        double mean, sd = 0;

        mean = mean(size, numbers);

        for(int i: numbers) {
            sd += Math.pow(i - mean,2);
        }

        sd = Math.sqrt(sd/size);

        System.out.printf("%.1f\n", sd);
    }

    private static double mean(int size, int[] numbers) {
        double mean =0;
        for(int i: numbers) {
            mean += i;
        }
        return mean/size;
    }
}
