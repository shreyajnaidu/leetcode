class Solution {
    public int singleNonDuplicate(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 != 0) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                // Correct pair → single is to the right
                left = mid + 2;
            } else {
                // Pair is broken → single is at or before mid
                right = mid;
            }
        }

        return nums[left];
    }
}