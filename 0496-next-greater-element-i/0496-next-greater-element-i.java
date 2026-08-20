class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Deque<Integer> st=new ArrayDeque();
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                int x=st.pop();
                map.put(x,nums2[i]);
            }
            st.push(nums2[i]);
        }
        int[] arr=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                arr[i]=map.get(nums1[i]);
            }else{
                arr[i]=-1;
            }
        }
        return arr;
    }
}