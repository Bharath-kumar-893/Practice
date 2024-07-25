public class IntCharArray {
    public static void main(String[] args) {
        int[] input1 = {10, 5, 70, 1};
        char[] output = generateCharArray(input1);
        for (char c : output) {
            System.out.print(c + " ");
        }
    }

    public static char[] generateCharArray(int[] input1) {
        int n = input1.length;
        char[] output = new char[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (input1[j] < input1[minIndex]) {
                    minIndex = j;
                }
            }
            swap(input1, i, minIndex);
            swap(indices, i, minIndex);
        }

        for (int i = 0; i < n; i++) {
            output[indices[i]] = (char) ('a' + i);
        }

        return output;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}