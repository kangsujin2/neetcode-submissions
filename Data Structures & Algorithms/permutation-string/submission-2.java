class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;
         if (s1Len == 0) return true;

        int[] s1Map = new int[26];
        for (char s : s1.toCharArray()) {
            s1Map[s - 'a']++;
        }
        
        int[] s2Map = new int[26];
        for (int i=0; i<s1Len; i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Map, s2Map)) return true;

        for (int i=0; i<s2Len-s1Len; i++) {

            s2Map[s2.charAt(i) - 'a']--;
            s2Map[s2.charAt(i + s1Len) - 'a']++;

            if (Arrays.equals(s1Map, s2Map)) return true;
        }

        return false;
    }
}
