class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> p = new Pair<>(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(p);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        String result = "";
        int l = 0;
        int r = values.size()-1;

        while (l<=r) {
            int m = l + (r-l)/2;

            if (values.get(m).getKey() <= timestamp) {
                result = values.get(m).getValue();
                l = m + 1;
            }
            else {
                r = m-1;
            }
        }

        return result;

    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
