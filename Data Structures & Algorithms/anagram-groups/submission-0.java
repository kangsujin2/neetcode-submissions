class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
}
