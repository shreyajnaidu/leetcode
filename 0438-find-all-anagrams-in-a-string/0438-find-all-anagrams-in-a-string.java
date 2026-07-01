class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int[] freq1=new int[26];
        int[] freq2 = new int[26];
        if(p.length()>s.length()){
            return result;
        }
    for(int i=0;i<p.length();i++){
        freq1[p.charAt(i)-'a']++;
    }

// Build frequency for the first window
    for (int i = 0; i < p.length(); i++) {
    freq2[s.charAt(i) - 'a']++;
    }
    if(Arrays.equals(freq1,freq2)){
        result.add(0);
    }

// Slide the window
    for (int right = p.length(); right < s.length(); right++) {

    // Character entering the window
    freq2[s.charAt(right) - 'a']++;

    // Character leaving the window
    freq2[s.charAt(right - p.length()) - 'a']--;

    if(Arrays.equals(freq1,freq2)){
        result.add(right-p.length()+1);
    }
}
return result;
    }
}