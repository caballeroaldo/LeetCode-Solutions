class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        
        for(int i = 0; i < magazine.length(); i++) {
            mag[magazine.charAt(i) - 'a']++;
        }
        
        for(int j = 0; j < ransomNote.length(); j++) {
            mag[ransomNote.charAt(j) - 'a']--;
            if(mag[ransomNote.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
        
    }
}