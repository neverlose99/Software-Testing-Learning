public class NumberProcessor {

    public static int processNumbers(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) { // vòng lặp
            if (arr[i] % 2 == 0) {            // rẽ nhánh
                sum += arr[i];
            } else {
                sum -= arr[i];
            }
        }

        if (sum > 0) { // rẽ nhánh thứ 2
            return 1;
        } else if (sum == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
