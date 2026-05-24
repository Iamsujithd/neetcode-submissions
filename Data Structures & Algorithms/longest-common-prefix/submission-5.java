class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Handle empty array edge case
        if (strs == null || strs.length == 0) return "";
        
        String init = strs[0]; // We use the first word as our measuring stick
        
        // OUTER LOOP: Go through each character index of the first word
        for (int i = 0; i < init.length(); i++) {
            char currentChar = init.charAt(i);
            
            // INNER LOOP: Check this exact index in every other word
            for (int j = 1; j < strs.length; j++) {
                
                // We must STOP and return the prefix if:
                // 1. The current word is too short (we reached its end)
                // 2. The character at this index doesn't match
                if (i == strs[j].length() || strs[j].charAt(i) != currentChar) {
                    
                    // Return everything from 0 up to (but not including) the current index
                    return init.substring(0, i); 
                }
            }
        }
        
        // If we make it all the way through without returning, 
        // the entire first word is the common prefix!
        return init;
    }

    
}