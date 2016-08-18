```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
    https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/
public class IntersectionofTwoArrays2 {

    // calculate occurence of every number, all as one if it occurs
    public static Map<Integer, Integer> occCount(int[] ints) {
        HashMap<Integer, Integer> occMap = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int val = ints[i];
            int occ = occMap.getOrDefault(val, 0);
            occMap.put(val, occ + 1);
        }
        return occMap;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> occMap = occCount(nums2);
        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            int count = occMap.getOrDefault(val, 0);
            if (count > 0) {
                vector.add(val);
                occMap.put(val, --count);
            }
        }

        for (int i = 0; i < vector.size(); i++) {
            nums1[i] = vector.get(i);
        }

        return Arrays.copyOfRange(nums1, 0, vector.size());
    }

    public static void main(String[] args) {
        // Integer[] result = list.stream().toArray(Integer[] :: new);
        int[] nums1 = {1, 2, 2, 4, 4, 4, 3, 5};
        int[] nums2 = {2, 2, 5, 4, 4, 4, 4, 4, 10};

        Arrays.stream(intersect(nums1, nums2)).forEach(System.out:: print);
    }
}
```