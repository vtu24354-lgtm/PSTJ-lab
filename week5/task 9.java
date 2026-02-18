class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // 1. Don't compare a word with itself (i != j)
                // 2. Check if words[i] is a substring of words[j]
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    // Break early so we don't add the same word twice 
                    // if it's a substring of multiple words
                    break; 
                }
            }
        }
        
        return result;
    }
}
