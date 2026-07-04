class Solution {
    public int lengthOfLastWord(String s) {
        String[] words=s.trim().split("\\s+");
        int size=words.length;
        int length=words[size-1].length();
        return length;
    }
}