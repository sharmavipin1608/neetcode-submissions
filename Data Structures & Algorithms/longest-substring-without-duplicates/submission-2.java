class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;
        if (s.length() < 2) return s.length();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;

        int max = 0;

        map.put(s.charAt(0), 0);

        while (right < s.length()) {
            char current = s.charAt(right);

            if (map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;
            }

            map.put(current, right);

            max = Math.max(max, right - left + 1);
            right = right + 1;
        }

        return max;
    }
}
