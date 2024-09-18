package Hw3;

import java.util.*;

public class Fraction {
    private float numerator;
    private float denominator;
    public Fraction (float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        float newNumerator = this.numerator * c.denominator + c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction minus (Fraction c ) {
        float newNumerator = this.numerator * c.denominator - c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction multi (Fraction c ) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction divi ( Fraction c ) {
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    private float gcd(float a, float b) { //greatest common divisor
        if (b==0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public Fraction normalize(Fraction c) {
        float gcd = gcd(this.numerator, this.denominator);
        float newNumerator = this.numerator / gcd;
        float newDenominator = this.denominator / gcd;

        return new Fraction(newNumerator, newDenominator);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of fractions: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Initialize the array
        Fraction[] fractions = new Fraction[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the numerator of the " + (i + 1) + " fraction: ");
            int numerator = sc.nextInt();
            System.out.print("Enter the denominator of the " + (i + 1) + " fraction: ");
            int denominator = sc.nextInt();
            fractions[i] = new Fraction(numerator, denominator);
        }
        //print the fractions
        System.out.print("Enter the v(th) fraction: ");
        int v = sc.nextInt();
        if (v > 0 && v <= n) {
            System.out.println("The V(th) fraction: " + v + ": " + fractions[v - 1]);
        } else {
            System.out.println("Invalid.");
        }

        //sum of n fractions:
        Fraction sum = new Fraction(0, 1);
        for (int i = 0; i < n; i++) {
            sum = sum.add(fractions[i]);
        }
        sum = sum.normalize(sum);
        System.out.println("Sum of n fractions: " + sum);

        // Add, minus, Multi, Divi
        Fraction result;
        System.out.println("Select:");
        System.out.println("1. Add");
        System.out.println("2. Minus");
        System.out.println("3. Multi");
        System.out.println("4. Divi");
        int choice = sc.nextInt();
        System.out.print("Choose the fractions in array: ");
        int fractionIndex = sc.nextInt();
        Fraction chosenFraction = fractions[fractionIndex - 1];

        switch (choice) {
            case 1:
                result = sum.add(chosenFraction);
                System.out.println("Sum: " + result.normalize(result));
                break;
            case 2:
                result = sum.minus(chosenFraction);
                System.out.println("Minus: " + result.normalize(result));
                break;
            case 3:
                result = sum.multi(chosenFraction);
                System.out.println("Multiple: " + result.normalize(result));
                break;
            case 4:
                result = sum.divi(chosenFraction);
                System.out.println("Divide: " + result.normalize(result));
                break;
            default:
                System.out.println("Invalid.");
        }
    }
}

