class Solution {
    public int maxVowels(String s, int k) {
        int left=0;
        int count=0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        for(int right=0;right<k;right++){
            if(map.containsKey(s.charAt(right))){
                count++;
            }
        }
        int maxLen=count;
        for(int right=k;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                count++;
            }
            if(right-left+1>k){
                left++;
                if(map.containsKey(s.charAt(left-1))){
                    count--;
                }
                maxLen=Math.max(maxLen,count);
            }
        }
        return maxLen;
    }
}