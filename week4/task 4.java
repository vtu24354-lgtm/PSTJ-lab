import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store the numbers we've seen so far
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // .add() returns false if the element is already present in the set
            if (!seen.add(num)) {
                return true; // Found a duplicate!
            }
        }
        
        // If the loop finishes, all elements are unique
        return false;
    }
}
