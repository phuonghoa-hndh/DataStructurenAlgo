package problem;

import java.util.Scanner;

public class ex3 {
    public static int sumDigit(int n) {
        int value = 0;
        int sum =0;
        if (n == 0)
            return 0;
        else
            return (n%10) + sumDigit(n/10);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so n: ");
        int n = sc.nextInt();
        System.out.println("Tong chu so n "+ sumDigit(n));

    }
}
