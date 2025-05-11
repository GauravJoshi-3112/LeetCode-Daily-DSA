public class Codec {

    HashMap<String,String> encodeMap = new HashMap<>();
    HashMap<String,String> decodeMap = new HashMap<>();
    int id = 0;
    String baseUrl = new String("http://tinyurl.com/");

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) return encodeMap.get(longUrl);
        id += 1;
        decodeMap.put(baseUrl+String.valueOf(id),longUrl);
        encodeMap.put(longUrl,baseUrl+String.valueOf(id));
        return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));