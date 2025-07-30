import java.util.*;

public class Divisors {

    public static List<Integer> getAllDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i); 
                }
            }
        }

        Collections.sort(divisors); 
        return divisors;
    }

    public static void main(String[] args) {
        int number = 36;
        List<Integer> result = getAllDivisors(number);

        System.out.println("Divisors of " + number + ": " + result);
    }
}
