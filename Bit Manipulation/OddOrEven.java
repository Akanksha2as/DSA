public class OddOrEven {
    public static void main(String[] args) {
        int num = 7;
        if (isEven(num)) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
