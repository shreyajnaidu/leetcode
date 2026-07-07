class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<char[]> zigzag = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Downward column
            char[] arr = new char[numRows];

            int row = 0;

            while (row < numRows && i < s.length()) {
                arr[row] = s.charAt(i);
                row++;
                i++;
            }

            zigzag.add(arr);

            // Upward diagonal
            row = numRows - 2;

            while (row > 0 && i < s.length()) {

                char[] diag = new char[numRows];

                diag[row] = s.charAt(i);

                zigzag.add(diag);

                row--;
                i++;
            }
        }

        // Read row by row
        StringBuilder ans = new StringBuilder();

        for (int r = 0; r < numRows; r++) {

            for (char[] arr : zigzag) {

                if (arr[r] != '\0') {
                    ans.append(arr[r]);
                }

            }
        }

        return ans.toString();
    }
}