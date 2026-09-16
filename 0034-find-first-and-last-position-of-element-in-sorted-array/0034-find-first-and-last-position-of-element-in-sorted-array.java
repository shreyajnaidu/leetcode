class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // Lower bound: first >= target
        int left = 0;
        int right = nums.length - 1;
        int ans1 = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans1 = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ans1 == nums.length || nums[ans1] != target) {
            return new int[]{-1, -1};
        }
        left = 0;
        right = nums.length - 1;
        int ans2 = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                ans2 = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{ans1, ans2 - 1};
    }
}
