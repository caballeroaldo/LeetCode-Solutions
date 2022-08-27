class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxRepeated = 0;
        int windowStart = 0;
        Map<Character, Integer> rep = new HashMap<>();
        
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            rep.put(rightChar, rep.getOrDefault(rightChar, 0) + 1);
            
            maxRepeated = Math.max(maxRepeated, rep.get(rightChar));
            
            if(windowEnd - windowStart + 1 - maxRepeated > k ) {
                char leftChar = s.charAt(windowStart);
                rep.put(leftChar, rep.get(leftChar) -1 );
                windowStart++;
            }
            
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }
        
        return maxLength;
    }
}