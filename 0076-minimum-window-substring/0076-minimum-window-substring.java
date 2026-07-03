class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Store required frequencies
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int formed = 0;
        int required = target.size();

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (target.containsKey(ch) &&
                window.get(ch).intValue() == target.get(ch).intValue()) {

                formed++;
            }

            while (formed == required) {

                // Update minimum answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                window.put(remove, window.get(remove) - 1);

                // Window became invalid
                if (target.containsKey(remove) &&
                    window.get(remove) < target.get(remove)) {

                    formed--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}