public class Test17 {

    public static void main(String[] args) {
        new Test17().print1ToMaxOfNDigits(3);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n < 1) {
            return;
        }
        char[] arr = new char[n];
        print1ToMaxOfNDigits(arr, 0);
    }

    private void print1ToMaxOfNDigits(char[] arr, int lenth) {
        if (lenth == arr.length) {
            print(arr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[lenth] = (char) (i + '0');
            print1ToMaxOfNDigits(arr, lenth + 1);
        }
    }

    private void print(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
