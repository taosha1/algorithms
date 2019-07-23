public class Test04 {

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param string     要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceBlank(char[] string, int usedLength) {

        if (string==null || string.length<usedLength){
            return -1;
        }

        int count = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }

        int totalLength = count * 2 + usedLength;
        for (int i = usedLength-1; i >= 0; i--) {
            int ptr = i + count * 2;
            if (string[i] != ' ')
                string[ptr] = string[i];
            else{
                string[ptr] = '0';
                string[ptr-1] = '2';
                string[ptr-2] = '%';
                //每次转换一个空格后 count都要减1，
                count--;
            }
        }
        return totalLength;
    }

    public static void test() {
        String s = " hello world by java. ";
        char[] string = new char[225];
        for (int i = 0; i < s.length(); i++) {
            string[i] = s.charAt(i);
        }
        System.out.println(new String(string));
//        System.out.println(replaceBlank(null, s.length()));
        System.out.println(replaceBlank(string, s.length()));
        System.out.println(new String(string));
    }

    public static void main(String[] args) {
        Test04.test();
    }
}
