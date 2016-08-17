```java
import java.util.Stack;

/**
    https://leetcode.com/problems/valid-parentheses/

   这个题目的意义已经不是简单算法题的问题, 而是对于数据结构的灵活应用了. 
   如果不是在Stack标签下, 我也许肯定做不出来.
   看到Stack, 就产生了一种感觉, 这题的解法就是栈中的内容要能在字符串遍历完成之后 全部出来,
   就像连连看一样, 成对才能出来.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();

        // '(', ')', '{', '}', '[' and ']'
        char pl1 = '(';
        char pr1 = ')';

        char pl2 = '{';
        char pr2 = '}';

        char pl3 = '[';
        char pr3 = ']';

        for (char c: chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
               char top = stack.peek();
                if ((top == pl1 && c == pr1) || (top == pl2 && c == pr2) || (top == pl3 && c == pr3)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String s1 = "[(){}]";
        String s2 = "[({})]";
        String s3 = "";
        String s4 = "[)({}]";
        String s5 = "[({}])";
        String s6 = "[{}]()";

        System.out.println(vp.isValid(s1));
        System.out.println(vp.isValid(s2));
        System.out.println(vp.isValid(s3));
        System.out.println(vp.isValid(s4));
        System.out.println(vp.isValid(s5));
        System.out.println(vp.isValid(s6));
    }

}
```