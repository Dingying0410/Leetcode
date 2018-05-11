public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //abcde vfg -> 5#abcde3#vfg
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length() + "#" + strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int index = s.indexOf("#", start);
        while (index != -1) {
            int len = Integer.valueOf(s.substring(start, index));
            res.add(s.substring(index + 1, index + 1 + len));
            start = index + 1 + len;
            index = s.indexOf("#", start);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
