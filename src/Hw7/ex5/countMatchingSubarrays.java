package Hw7.ex5;

public class countMatchingSubarrays {
    public static int count(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        for (int i = 0; i <= n - m - 1; i++) {
            boolean match = true;
            for (int k = 0; k < m; k++) {
                if ((pattern[k] == 1 && nums[i + k + 1] <= nums[i + k]) ||
                        (pattern[k] == 0 && nums[i + k + 1] != nums[i + k]) ||
                        (pattern[k] == -1 && nums[i + k + 1] >= nums[i + k])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5, 6};
            int[] pattern = {1, 1};
            System.out.println(count(nums, pattern));
    }
}



