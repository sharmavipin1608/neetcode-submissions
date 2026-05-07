class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            //odd
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            
            //even
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }    

        return count;
    }
}
