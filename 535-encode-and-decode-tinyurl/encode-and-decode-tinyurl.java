public class Codec {

    private final String BASE_URL = "http://tinyurl.com/";

    HashMap<String, String> encodedMap = new HashMap<>();
    HashMap<String, String> decodedMap = new HashMap<>();

    int code = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodedMap.containsKey(longUrl)) return encodedMap.get(longUrl);
        encodedMap.put(longUrl, BASE_URL+code);
        decodedMap.put(BASE_URL+code, longUrl);
        code++;
        return encodedMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodedMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));