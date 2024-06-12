package generics.type_erasure;

class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }
    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
public class BridgeMethodBeforeErasure {
    public static void main(String[] args) {
        Node<Integer> node = new MyNode(4);
        node.setData(5);
    }
}
