package d1;

import java.util.Arrays;
import java.util.Scanner;

public class Q3InterquantileRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String tokens[] = s.split(" ");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        s = scanner.nextLine();
        tokens = s.split(" ");
        int[] freq = new int[size];
        for (int i = 0; i < size; i++) {
            freq[i] = Integer.parseInt(tokens[i]);
        }
        solve(size, numbers, freq);
    }

    private static void solve(int size, int[] numbersN, int[] freq) {
        double q1, q3;

        int qtd = 0;
        for(int i: freq) {
            qtd += i;
        }

        int[] numbers = new int[qtd];
        int c = 0;
        for (int i = 0; i<size; i++) {
            for (int i2=0; i2 < freq[i]; i2++) {
                numbers[c++] = numbersN[i];
            }
        }

        Arrays.sort(numbers);
        int from = qtd / 2;
        int[] q1N = Arrays.copyOfRange(numbers, 0, from);
        if (size % 2 != 0)
            from ++;
        int[] q3N = Arrays.copyOfRange(numbers, from, qtd);
        q1 = median(q1N.length, q1N);
        q3 = median(q3N.length, q3N);

        System.out.printf("%.1f\n", q3-q1);

    }

    private static int median(int size, int[] numbers) {
        int median = numbers[size/2];
        if (size % 2 == 0) {
            median = (median + numbers[size/2 - 1])/2;
        }
        return median;
    }
}
