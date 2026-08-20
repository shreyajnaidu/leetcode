class Solution {
    public int[] nextGreaterElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Deque<Integer> st=new ArrayDeque();
        int n=nums.length;
        for(int i=0;i<2*n;i++){
            int index=i%n;
            int current=nums[index];
            while(!st.isEmpty() && current>nums[st.peek()]){
                int x=st.pop();
                map.put(x,current);
            }
            st.push(index);
        }
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(i)){
                arr[i]=map.get(i);
            }else{
                arr[i]=-1;
            }
        }
        return arr;
    }
}