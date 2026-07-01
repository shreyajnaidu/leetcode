class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2 = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
    for(int i=0;i<s1.length();i++){
        freq1[s1.charAt(i)-'a']++;
    }

// Build frequency for the first window
    for (int i = 0; i < s1.length(); i++) {
    freq2[s2.charAt(i) - 'a']++;
    }
    if(Arrays.equals(freq1,freq2)){
        return true;
    }

// Slide the window
    for (int right = s1.length(); right < s2.length(); right++) {

    // Character entering the window
    freq2[s2.charAt(right) - 'a']++;

    // Character leaving the window
    freq2[s2.charAt(right - s1.length()) - 'a']--;

    if(Arrays.equals(freq1,freq2)){
        return true;
    }
}
return false;
    }
}