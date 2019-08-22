public class Test44 {


    public int getDigitAtIndex(int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= index; i++) {
            if (sb.toString().length() <= index + 1) {
                sb.append(i);
            }
        }
        return sb.toString().charAt(index) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Test44().getDigitAtIndex(13));
        System.out.println(new Test44().getDigitAtIndex(19));

    }
}
