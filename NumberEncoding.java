public class NumberEncoding{
    public static void main(String[] args) {
        int[] input1 = {12, 123456, 1234567};
        String[] output = transformCodes(input1);
        for (String s : output) {
            System.out.println(s);
        }
    }

    public static String[] transformCodes(int[] input1) {
        String[] output = new String[input1.length];
        for (int i = 0; i < input1.length; i++) {
            output[i] = transformCode(input1[i]);
        }
        return output;
    }

    private static String transformCode(int n) {
        StringBuilder answer = new StringBuilder();
        if (String.valueOf(n).length() == 6) {
            answer.append("C");
        } else {
            answer.append("W");
        }

        if (n == 0) {
            answer.append("Z");
        } else if (n == 1) {
            answer.append("O");
        } else if (isPrime(n)) {
            answer.append("P");
        } else {
            answer.append("N");
        }

        int sum = sumOfDigits(n);
        answer.append(sum);

        if (n % 2 == 0) {
            answer.append(n / 2);
        } else {
            answer.append((n - 1) / 2);
        }

        return answer.toString();
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum > 9) {
            sum = sumOfDigits(sum);
        }
        return sum;
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