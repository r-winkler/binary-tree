public class Node implements Comparable<Node>{

    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(Node o) {
        if (this.value > o.value){
            return 1;
        }
        else{
            return -1;
        }
    }

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    public boolean hasNoRightChild() {
        return right == null;
    }
}
