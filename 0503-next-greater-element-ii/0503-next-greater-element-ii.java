class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    Deque<Integer> st = new ArrayDeque<>();

    for (int i = 0; i < 2 * n; i++) {
        int index = i % n;
        int current = nums[index];

        while (!st.isEmpty() && current > nums[st.peek()]) {
            int x = st.pop();
            ans[x] = current;
        }

        if (i < n) {
            st.push(index);
        }
    }

    return ans;
}
}