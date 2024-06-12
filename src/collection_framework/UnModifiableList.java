package collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    private int value;
    private List<Node> neighbours;

    public Node(int value) {
        this.value = value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
    public List<Node> getNeighbours() {
        return neighbours;
    }
    public List<Node> getNeigboursUnmodifiable() {
        return Collections.unmodifiableList(neighbours);
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
public class UnModifiableList {
    public static void main(String[] args) {

        Node mainNode = new Node(55);
        createNeighbours(mainNode);
        System.out.println(mainNode.getNeighbours());

        Node newNode = new Node(99);
        /**
         * Here with default getter, caller method is able to modify the original list
         */
        mainNode.getNeighbours().add(newNode);

        /**
         * Solution is to return unmodifiable list when getter is called
         */
        mainNode.getNeigboursUnmodifiable().add(newNode);

        System.out.println(mainNode.getNeighbours());
    }

    static void createNeighbours(Node mainNode) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        mainNode.setNeighbours(nodes);
    }
}
