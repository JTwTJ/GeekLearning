
/**
 * @author jiangwentao
 * @date 2021/3/10
 */
public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    private int size = 0;

    public void put(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        }
        Node<T> parentNode = null;
        Node<T> node = root;
        while (node != null) {
            parentNode = node;
            if (node.data.compareTo(data) > 0) {
                node = node.leftChild;
            } else if (node.data.compareTo(data) < 0) {
                node = node.rightChild;
            } else {
                return;
            }
        }
        if (parentNode.data.compareTo(data) > 0) {
            parentNode.leftChild = newNode;
        } else {
            parentNode.rightChild = newNode;
        }
        newNode.parent = parentNode;
        size++;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    public class Node<T extends Comparable> {

        T data;
        Node<T> leftChild;
        Node<T> rightChild;
        Node<T> parent;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
        for (int j = 0; j < 10; j++) {
            searchTree.put(j);
        }
        System.out.println(searchTree);
    }
}
