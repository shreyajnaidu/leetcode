class Solution {
    public int compress(char[] chars) {

        int i = 0;
        int index = 0;

        while (i < chars.length) {

            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }
            chars[index++] = ch;
            if (count > 1) {
                String str = Integer.toString(count);

                for (char c : str.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}