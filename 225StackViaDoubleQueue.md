```java
/*
   https://leetcode.com/problems/implement-stack-using-queues/

   ugly implementation
*/
public class StackByQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> backup = new LinkedList<>();

    // Push element x onto stack.
    // 对于队列是添加在尾部
    public void push(int x) {

        // 如果某方不为空, 则向另外一方加入
        if (!backup.isEmpty()) {
            backup.add(x);
            return;
        }

        queue.add(x);
    }

    // Removes the element on top of the stack.
    // 对于队列是移除头部元素
    public void pop() {
        if (!backup.isEmpty()) {

            while (backup.size() > 1) {
                queue.add(backup.remove());
            }

            backup.remove();
            return;
        }

        while (queue.size() > 1) {
            backup.add(queue.remove());
        }

        queue.remove();
    }

    // 对于栈, 是栈顶元素

    // 对于队列取出头部元素
    public int top() {
        if (!backup.isEmpty()) {
            while (backup.size() > 1) {
                queue.add(backup.remove());
            }

            int last = backup.remove();
            queue.add(last);
            return last;
        }

        while (queue.size() > 1) {
            backup.add(queue.remove());
        }

        int last = queue.remove();
        backup.add(last);
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty() && backup.isEmpty();
    }

    public static void main(String[] args) {

        StackByQueue sb = new StackByQueue();

        sb.push(1);
        sb.push(2);

        System.out.println("sb.top() == 2");
        System.out.println(sb.top() == 2);
        sb.pop();

        System.out.println(sb.top() == 1);

        sb.push(3);
        System.out.println(" sb.push(3); " + sb.top());

        sb.push(4);
        sb.push(5);
        sb.push(6);

        System.out.print(" 4 -> 5 -> 6 ");
        System.out.print(sb.top() == 6);
        System.out.println();

        sb.pop();
        sb.pop();

        System.out.println(" 4 <- 5 <- 6 出栈之后 " + sb.top());

        sb.pop();
        sb.pop();

        System.out.println(sb.top());


        sb.push(10);

        System.out.println(" push 10 and get " + sb.top());
    }

}
```