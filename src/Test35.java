import java.util.*;

public class Test35 {

    public static char firstNotRepeatingChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c,1);
            }else {
                map.put(c,map.get(c)+1);
            }
        }
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (map.get(next) == 1) {
                return next;
            }
        }
//        throw new RuntimeException("invalid input");
        return '\0';
    }


    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("google")); // l
        System.out.println(firstNotRepeatingChar("aabccdbd")); // '\0'
        System.out.println(firstNotRepeatingChar("abcdefg")); // a
        System.out.println(firstNotRepeatingChar("gfedcba")); // g
        System.out.println(firstNotRepeatingChar("zgfedcba")); // z
    }
}
