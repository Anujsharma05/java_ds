package generics.type_erasure;

class NodeEr {
    public Object data;

    public NodeEr(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNodeEr extends NodeEr {
    public MyNodeEr(Integer data) {
        super(data);
    }

    // This method does not override Node.setData(Object)!
    //To point to this method for inheritance, we use the bridge method
//    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

    // Synthetic bridge method to establish the inheritance
    public void setData(Object data) {
        setData((Integer) data); // Call the actual overridden method
    }

}

public class BridgeMethod {
    public static void main(String[] args) {
        MyNodeEr mn = new MyNodeEr(5);
        NodeEr n = mn; // A raw type - compiler throws an unchecked warning
        n.setData("Hello"); // Causes a ClassCastException to be thrown
//        Integer x = (Integer)mn.data;

    }
}
