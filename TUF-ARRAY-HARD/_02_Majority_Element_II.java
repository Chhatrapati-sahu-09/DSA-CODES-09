import java.util.*;

public class _02_Majority_Element_II {

    public static List<Integer> bruteForce(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (ans.contains(nums[i])) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public static List<Integer> better(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static List<Integer> optimal(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {

            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;

        if (count1 > n / 3) {
            ans.add(candidate1);
        }

        if (count2 > n / 3) {
            ans.add(candidate2);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = { 3, 2, 3 };
        int[] nums2 = { 1 };
        int[] nums3 = { 1, 2 };
        int[] nums4 = { 1, 1, 1, 3, 3, 2, 2, 2 };

        System.out.println("Brute Force");
        System.out.println(bruteForce(nums1));
        System.out.println(bruteForce(nums2));
        System.out.println(bruteForce(nums3));
        System.out.println(bruteForce(nums4));

        System.out.println();

        System.out.println("Better");
        System.out.println(better(nums1));
        System.out.println(better(nums2));
        System.out.println(better(nums3));
        System.out.println(better(nums4));

        System.out.println();

        System.out.println("Optimal");
        System.out.println(optimal(nums1));
        System.out.println(optimal(nums2));
        System.out.println(optimal(nums3));
        System.out.println(optimal(nums4));
    }
}