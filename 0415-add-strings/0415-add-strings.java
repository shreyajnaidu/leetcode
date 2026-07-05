class Solution {
    public String addStrings(String num1, String num2) {

        int carry = 0;
        int size = Math.min(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder();

        // Common digits
        for (int k = size - 1; k >= 0; k--) {
            int c1 = num1.charAt(num1.length() - size + k) - '0';
            int c2 = num2.charAt(num2.length() - size + k) - '0';

            int sum = carry + c1 + c2;

            sb.append((char) ((sum % 10) + '0'));
            carry = sum / 10;
        }

        // Remaining digits of num1
        if (num1.length() > num2.length()) {

            for (int k = num1.length() - size - 1; k >= 0; k--) {

                int c1 = num1.charAt(k) - '0';

                int sum = carry + c1;

                sb.append((char) ((sum % 10) + '0'));
                carry = sum / 10;
            }

        }
        // Remaining digits of num2
        else if (num2.length() > num1.length()) {

            for (int k = num2.length() - size - 1; k >= 0; k--) {

                int c2 = num2.charAt(k) - '0';

                int sum = carry + c2;

                sb.append((char) ((sum % 10) + '0'));
                carry = sum / 10;
            }
        }

        if (carry != 0) {
            sb.append((char) (carry + '0'));
        }

        return sb.reverse().toString();
    }
}