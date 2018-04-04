public class Codec {

    // Encodes a URL to a shortened URL.
    String prefix2 = "http://tinyurl.com/";
    List<String> list;
    
    public Codec () {
        list = new ArrayList<>();
    }
    
    public String encode(String longUrl) {
        int size = list.size();
        list.add(longUrl);
        return prefix2 + size;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int num = Integer.valueOf(shortUrl.substring(prefix2.length()));
        return list.get(num);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));