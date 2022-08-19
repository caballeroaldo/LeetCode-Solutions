class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> count = new HashSet<>();
        int start = 0;
        int res = 0;
        for(int end = 0; end < s.length(); end++) {
            while(count.contains(s.charAt(end))) {
                count.remove(s.charAt(start));
                start++;
            }
            count.add(s.charAt(end));
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}