package Week6and8;
import java.util.*;

public class HanoiTowers {
    static void move(int n, char a, char b, char c) {
        if (n==1) {
            System.out.println(a + " --> " + c);
        } else {
            move(n-1, a, c, b);
            move(1, a, ’ ’, c);
            move(n-1, b, a, c);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        move(3, ’a’, ’b’, ’c’);
    }
}

