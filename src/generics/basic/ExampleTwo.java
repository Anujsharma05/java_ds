package generics.basic;

class Hashtable<K, V> {

    private K key;
    private V value;

    public Hashtable(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return "Hashtable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
public class ExampleTwo {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>("Anuj", 27);
        System.out.println(hashtable);
    }
}
