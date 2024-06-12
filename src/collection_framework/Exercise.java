package collection_framework;

import java.util.ArrayList;
import java.util.List;
class Pair {
    private String url;
    private String content;

    public Pair(String url, String content) {
        this.url = url;
        this.content = content;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return url;
    }
}

class Cache {

    // we can store up to 5 items in the cache
    private static final int CAPACITY = 5;
    // let's use a list to store the items (URLs)
    private List<Pair> cache;

    public Cache() {
        cache = new ArrayList<>();
    }

    // YOUR IMPLEMENTATION HERE !!!
    public void search(String url) {
        boolean urlAlreadyExist = cache.stream().map(Pair::getUrl).anyMatch(pairUrl -> pairUrl.equals(url));

        if(urlAlreadyExist) return;

        if(cache.size() == CAPACITY) {
            cache.remove(0);
        }
        Pair pair = new Pair(url, url);
        cache.add(pair);
    }
    // I need it to test your implementation
    public List<Pair> getCache() {
        return this.cache;
    }

    public void showCache() {
        for(Pair pair : cache)
            System.out.println(pair);
    }
}
public class Exercise {
    public Cache useCache() {
        Cache cache = new Cache();

        cache.search("www.facebook.com");
        cache.search("www.google.com");
        cache.search("www.amazon.com");
        cache.search("www.google.com");
        cache.search("www.facebook.com");
        cache.search("www.twitter.com");
        cache.search("www.globalsoftwaresuppot.com");
        cache.search("www.bbc.com");
        cache.search("www.cnn.com");
        cache.search("www.google.com");
        cache.search("www.amazon.com");
        cache.search("www.google.com");
        cache.search("www.facebook.com");

        // the cache remembers the recently visited URLs (in this case: facebook, google, amazon, cnn, bbc - 5 because the capacity of the cache is 5)


        cache.showCache();

        // I need it to be able to test wether your implmenetation works fine
        return cache;
    }
    public static void main(String[] args) {
        Exercise ex = new Exercise();
        ex.useCache();
    }
}
