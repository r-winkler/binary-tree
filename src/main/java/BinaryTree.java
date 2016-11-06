import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;
    private int size = 0;

    public Node getRoot() {
        return root;
    }

    public void add(Integer i) {
        Node node = new Node(i);

        if (size == 0) {
            this.root = node;
        } else {
            add(root, node);
        }

        size++;
    }

    public void add(Node current, Node node) {

        if (node.compareTo(current) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }

        } else {
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                add(current.getRight(), node);
            }
        }
    }

    public boolean contains(Integer value) {
        Node node = new Node(value);
        return find(root, node) != null;
    }

    public Node find(Node current, Node node) {
        if (current == null) {
            return null;
        }

        if (current.getValue() == node.getValue()) {
            return current;
        }

        if (node.compareTo(current) < 0) {
            return find(current.getLeft(), node);

        }
        return find(current.getRight(), node);

    }

    public List<Node> findWithParent(Node current, Node node, Node parent) {
        List<Node> list = new ArrayList();
        list.add(current);
        list.add(parent);
        if (current == null) {
            return null;
        }

        if (current.getValue() == node.getValue()) {
            return list;
        }

        if (node.compareTo(current) < 0) {
            return findWithParent(current.getLeft(), node, current);

        }
        return findWithParent(current.getRight(), node, current);
    }


    public void preOrderTraversal(Node current) {
        if (current == null) {
            return;
        }
        preOrderTraversal(current.getLeft());
        preOrderTraversal(current.getRight());
        System.out.print(current.getValue() + " ");
    }

    public void inOrderTraversal(Node current) {
        if (current == null) {
            return;
        }
        inOrderTraversal(current.getLeft());
        System.out.print(current.getValue() + " ");
        inOrderTraversal(current.getRight());
    }

    public void postOrderTraversal(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getValue() + " ");
        postOrderTraversal(current.getLeft());
        postOrderTraversal(current.getRight());
    }

    public void remove(Integer value) {
        Node node = new Node(value);

        // find node
        List<Node> list = findWithParent(root, node, null);

        if (list == null) {
            return;
        }
        Node current = list.get(0);
        Node parent = list.get(1);

        size--;

        // case 1: has no right child
        if (current.hasNoRightChild()) {
            if (parent == null) {
                root = current.getLeft();
            }
            else {
                // promote left child
                int result = parent.compareTo(current);
                if (result > 0) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        }

        // case 2: has right child without left child
        else if (current.getRight().getLeft() == null){
            // promote right child
            current.getRight().setLeft(current.getLeft());

            if (parent == null) {
                root = current.getRight();
            }
            else {
                int result = parent.compareTo(current);
                if (result > 0) {
                    parent.setLeft(current.getRight());
                }
                else {
                    parent.setRight(current.getRight());
                }
            }
        }


        // case 3: has right child with left child
        else {
            // promote most-left child
            Node leftMost = current.getRight().getLeft();
            Node leftMostParent = current.getRight();

            while(leftMost.getLeft() != null) {
                leftMostParent = leftMost;
                leftMost = leftMostParent.getLeft();
            }

            leftMostParent.setLeft(leftMost.getRight());

            leftMost.setLeft(current.getLeft());
            leftMost.setRight(current.getRight());

            if (parent == null) {
                root = leftMost;
            }
            else {
                int result = parent.compareTo(current);
                if (result > 0) {
                    parent.setLeft(leftMost);
                }
                else {
                    parent.setRight(leftMost);
                }
            }
        }

    }

}
