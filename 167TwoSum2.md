```java

/*
	对于排序的数组(升序)中的两个数相加，有一个隐藏的事实:

	最小的两个数之和 应该 array[0] + array[1]
	最大的两个数之和 应该 array[N - 1] + array[N]

	可以模拟指向头尾index的两个指针然后同时『面向』移动, 并且将index对应的数与target number进行比较然后继续移动，直到找到指定index或者是重合时停止
*/


public int[] twoSum(int[] numbers, int target) {
    int numsLength = numbers.length;
    int head = 0;
    int tail = numsLength - 1;

    while (tail >= 0 && head <= tail) {
        int actualSum = numbers[head] + numbers[tail];

        if (actualSum < target) {
            head ++;
        } else if (actualSum > target) {
            tail --;
        } else {
            return new int[]{head + 1, tail + 1};
        }
    }

    return new int[]{1, 1};
}


```