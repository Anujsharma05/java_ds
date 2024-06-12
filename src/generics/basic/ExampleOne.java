package generics.basic;

import java.util.ArrayList;
import java.util.List;

class Store<T> {
    private T item;
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }
}

/**
 * Store class's internal implementation
 */
class StoreInternalImplementation {
    private Object item;
    public Object getItem() { return item; }
    public void setItem(Object item) {
        this.item = item;
    }
}
public class ExampleOne {
    public static void main(String[] args) {
        Store<String> store = new Store();
        store.setItem("Hello");
        String item = store.getItem();
        System.out.println(item);

        List l = new ArrayList();
        l.add(33);
        l.add("dd");
        System.out.println(l);
    }
}
