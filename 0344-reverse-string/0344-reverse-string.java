class Solution {
    public void reverse(int left,int right,char[] s){
        if(left>=right) return;
        char temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        reverse(left+1,right-1,s);
    }
    public void reverseString(char[] s) {
       reverse(0,s.length-1,s);
    }
}