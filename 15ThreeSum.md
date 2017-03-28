```java
/*
	+ 允许O(n ^ 2)的时间复杂度
	+ `a + b + c = 0`，那么`b + c = -a`, 转换成twoSum的问题
	+ <b style="color:red">两次去重</b>
	**第一个数后面的重复部分**，肯定在它第一次出现的时候参与过运算。
	上面的测试用例1，第一个-1，会在后面的部分寻找两个相加为1的数，所以第二个-1参与过1次统计，因此需要过滤掉。
	**twoSum部分的去重**，这个很明显1 + 2 = 3，如果1和2出现多次则会统计多次，参照上面的方法进行过滤。
*/

public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < nums.length - 1; i ++) {
        // 三个相加的第一个数 也要跳过重复数据; 后一个相同已经参与过运算了
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int one = nums[i];
            int head = i + 1;
            int tail = nums.length - 1;
            int twoSumTarget = 0 - one;

            while (head < tail) {
                if (nums[head] + nums[tail] == twoSumTarget) {
                    triplets.add(Arrays.asList(one, nums[head], nums[tail]));
                    // 在寻找twoSum的时候跳过重复数据
                    while (head < tail && nums[head] == nums[head + 1]) { head ++; }
                    while (head < tail && nums[tail] == nums[tail - 1]) { tail --; }
                    head ++; tail --;
                } else if (nums[head] + nums[tail] < twoSumTarget) {
                   head ++;
                } else {
                   tail --;
                }
            }
        }
    }

    return triplets;
}
```