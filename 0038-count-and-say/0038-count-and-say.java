class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder result = new StringBuilder();
            int j = 0;
            while (j < str.length()) {
                char ch = str.charAt(j);
                int count = 0;
                while (j < str.length() && str.charAt(j) == ch) {
                    count++;
                    j++;
                }
                result.append(count);
                result.append(ch);
            }
            str = result.toString();
        }
        return str;
    }
}