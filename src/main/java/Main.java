public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(2);
        tree.add(8);
        tree.add(1);

        tree.preOrderTraversal(tree.getRoot());
        System.out.println();
        tree.inOrderTraversal(tree.getRoot());
        System.out.println();
        tree.postOrderTraversal(tree.getRoot());

        System.out.println();
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(6));
        System.out.println(tree.contains(7));
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(10));

        System.out.println("=== Removing ====");
        tree.remove(5);
        tree.remove(3);
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(5));
    }

}
