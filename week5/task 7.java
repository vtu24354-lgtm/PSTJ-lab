import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store characters and their last seen index
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we've seen this char before, move the left pointer
            if (map.containsKey(currentChar)) {
                // We move 'left' to the right of the previous occurrence,
                // but only if that occurrence is inside our current window.
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the last seen index of the character
            map.put(currentChar, right);

            // Calculate the window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
