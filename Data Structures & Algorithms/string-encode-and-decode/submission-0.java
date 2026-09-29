class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int size = str.length();
        int index = 0;

        while (index < size) {
            int p = str.indexOf("#", index);
            int length = Integer.parseInt(str.substring(index, p));
            decoded.add(str.substring(p + 1, p + 1 + length));
            index = p + 1 + length;
        }

        return decoded;

    }
}
