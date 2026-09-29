class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int end = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            int index = map.get(s.charAt(i));
            end = Math.max(end, index); 

            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;          
            }
        }

        return res;
    }
}
