```java
/*
    https://leetcode.com/problems/reverse-string/

    选择合适的数据结构
*/
public class ReverseString {
    // 击败61.06%
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] reversed = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            reversed[len - 1 - i] = chars[i];
        }
        return String.valueOf(reversed);
    }

    // 击败11.06%
    public String reverseString1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] reversed = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            reversed[len - 1 - i] = chars[i];
        }
        return String.valueOf(reversed);
    }

    public static void main(String[] args) {
        int[] arr = {};
        ReverseString revStr = new ReverseString();
        String str = "hello";
        System.out.println(" result  " + revStr.reverseString(str));
    }
}
```