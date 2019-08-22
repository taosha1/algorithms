public class Test20 {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
    }


    public boolean isNumeric2(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?[1-9]+(\\.\\d+)?([eE][+-][\\d+])?");
    }


    public static void main(String[] args) {
        new Test19().isMatch2("aa", "a*");
//        char[] arr = {'-', '.', '2'};
        char[] arr = {'-', '1', '.', '2'};
        System.out.println(new Test20().isNumeric2(arr)
        );
    }

}
