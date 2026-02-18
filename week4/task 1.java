class Solution {
    public boolean halvesAreAlike(String s) {
        // Define all vowels in a string for easy lookup
        String vowels = "aeiouAEIOU";
        int count = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < mid; i++) {
            // Check the first half: increment the count if it's a vowel
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
            // Check the second half: decrement the count if it's a vowel
            if (vowels.indexOf(s.charAt(i + mid)) != -1) {
                count--;
            }
        }

        // If count returns to 0, both halves had the same number of vowels
        return count == 0;
    }
}
