```java
import java.util.Stack;

/**
    https://leetcode.com/problems/min-stack/

    retrieving the minimum element in constant time.

    支持取出最小值栈, 所以需要维护一个比较结果栈
*/

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else {
            // 原栈的顶部元素 和 新加入元素的 小的一方放入MinStack
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    //["MinStack","push","push","push","getMin","pop","pop", "getMin", "top"]
    // [[],[3],[1],[4],[],[],[],[]]

    // ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
    // [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);

        System.out.println(ms.top());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        ms.push(2147483647);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        ms.push(-2147483648);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
```