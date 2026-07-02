class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq=0;
        int[] freq=new int[26];
        int left=0;
        int windowlen=0;
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
            windowlen++;
            while(windowlen-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
                windowlen--;
            }
            maxLen=Math.max(maxLen,windowlen);
        }
        return maxLen;
    }
}