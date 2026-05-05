class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) return "";   

        Map<Character, Integer> countT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        } 

        int have = 0;
        int need = countT.size();

        int l = 0;
        int[] coord = {-1,-1};
        int min = Integer.MAX_VALUE;

        Map<Character, Integer> countS = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            countS.put(current, countS.getOrDefault(current, 0) + 1);

            if (countT.containsKey(current) && countT.get(current) == countS.get(current)) {
                have++;
            }

            while (have == need) {
                //System.out.println(s.substring(l,r + 1));
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    //result = s.substring(l, r + 1);
                    //System.out.println("min : " + min);
                    coord[0] = l;
                    coord[1] = r;
                }

                char lChar = s.charAt(l);

                if (countT.containsKey(lChar)) {
                    countS.put(lChar, countS.get(lChar) - 1);

                    if (countS.get(lChar) < countT.get(lChar)) {
                        have--;
                    }
                }

                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(coord[0], coord[1] + 1);
    }
}
