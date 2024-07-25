public class SumOfPrime{
    public static void main(String[] args) {
        int[] input1 = {10, 41, 18, 50, 43, 31, 29, 25, 59, 96, 67};
        int input2 = 11;
        int sum = findSumOfPrimesExceptSmallest(input1, input2);
        System.out.println("Sum of prime numbers except smallest prime: " + sum);
    }

    public static int findSumOfPrimesExceptSmallest(int[] input1, int input2) {
        int smallestPrime = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < input2; i++) {
            if (isPrime(input1[i])) {
                if (input1[i] < smallestPrime) {
                    smallestPrime = input1[i];
                }
                sum += input1[i];
            }
        }
        return sum - smallestPrime;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}