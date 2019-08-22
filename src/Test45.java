import java.util.Arrays;
import java.util.Comparator;

public class Test45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return null;
        }
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo((o2 + o1));
            }
        });

        String ret = "";
        for (String str : strings)
            ret += str;
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 23,44,25};
        System.out.println(new Test45().PrintMinNumber(arr));

    }
}
