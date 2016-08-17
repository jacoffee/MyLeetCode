```java
import java.util.Stack;

/**
    https://leetcode.com/problems/implement-queue-using-stacks/

     Stack

     |   C  |  top
     |   B  |
     |   A  |  bottom

    Queue

    end |  C -> B -> A  | front

    出栈的时候将元素进行栈间转移

 */
public class QueueByStack {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> backup = new Stack();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    // Removes the element from the bottom from Stack
    public void pop() {
        if (!backup.isEmpty()) {
            backup.pop();
            return;
        }

        while (stack.size() != 1) {
          backup.push(stack.pop());
        }

        stack.pop();
    }

    // Get the front element.

    // Get the bottom element from Stack
    public int peek() {
        if (!backup.isEmpty()) return backup.peek();

        while (stack.size() != 1) {
            backup.push(stack.pop());
        }
        return backup.push(stack.pop());
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty() && backup.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack qbs = new QueueByStack();

        // 3 -> 2 -> 1
        qbs.push(1);
        qbs.push(2);
        qbs.push(3);

        System.out.println(" qbs.peek() == 1 ");
        System.out.println(qbs.peek() == 1);

        qbs.pop();

        System.out.println("qbs.peek() == 2");
        System.out.println(qbs.peek() == 2);

        qbs.push(4);
        qbs.pop();

        System.out.println(qbs.peek());

        qbs.pop();
        System.out.println(qbs.peek());
        qbs.pop();

        System.out.println(qbs.empty());

        qbs.push(6);
        qbs.push(7);

        System.out.println(qbs.peek() == 6);
        qbs.pop();
        System.out.println(qbs.peek() == 7);
    }

}
```