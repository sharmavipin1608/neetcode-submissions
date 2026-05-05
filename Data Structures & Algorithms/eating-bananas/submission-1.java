class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left)/2;

            int currentTotal = 0;
            for (int p : piles) {
                currentTotal += Math.ceil((double) p / mid);
            }

            if (currentTotal <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;    
    }
}
