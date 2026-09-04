class Solution {

    List<List<String>> result = new ArrayList<>();

    public boolean isPalindrome(String a) {
        int n = a.length();

        for (int i = 0; i < n / 2; i++) {
            if (a.charAt(i) != a.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void solve(int start, String s, List<String> current) {

        // We have successfully used the entire string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = start; i < s.length(); i++) {

            sb.append(s.charAt(i));

            if (isPalindrome(sb.toString())) {

                // choose
                current.add(sb.toString());

                // explore remaining part
                solve(i + 1, s, current);

                // undo choice
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        solve(0, s, new ArrayList<>());

        return result;
    }
}