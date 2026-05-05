class TimeMap {
    private record Pair(String value, int timestamp) {}

    Map<String, List<Pair>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String result = "";

        List<Pair> pairs = store.get(key);

        if (null == pairs) return result;

        int left = 0, right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (pairs.get(mid).timestamp() == timestamp) {
                return pairs.get(mid).value();

            } else if (pairs.get(mid).timestamp() < timestamp) {
                result = pairs.get(mid).value();
                left = mid + 1;
            
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
