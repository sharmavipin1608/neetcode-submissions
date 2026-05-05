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
        String result = "";
        int min = s.length() + 1;

        Map<Character, Integer> countS = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            countS.put(current, countS.getOrDefault(current, 0) + 1);

            if (countT.containsKey(current) && countT.get(current) == countS.get(current)) {
                have++;
            }

            while (have == need) {
                System.out.println(s.substring(l,r + 1));
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    result = s.substring(l, r + 1);
                    System.out.println("min : " + min);
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

        return result;
    }
}
