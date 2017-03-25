```java
import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAccessedWithIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
             int one = nums[i];
             int other = target - one;

             Integer otherIndexIfExists = numAccessedWithIndex.get(other);
             if (otherIndexIfExists != null) {
                 return new int[] {otherIndexIfExists.intValue(), i};
             }

             numAccessedWithIndex.put(one, i);
        }

        return new int[]{0, 0};
    }

}
```