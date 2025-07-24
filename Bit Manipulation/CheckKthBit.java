public class CheckKthBit {
    public static void main(String[] args) {
        int n = 5; // number
        int k = 0; // 0-based index for bit

        boolean result = isKthBitSet(n, k);
        if (result) {
            System.out.println("K-th bit is SET");
        } else {
            System.out.println("K-th bit is NOT SET");
        }
    }

    public static boolean isKthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }
}
