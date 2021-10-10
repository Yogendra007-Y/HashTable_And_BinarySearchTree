package com.bridgelabz;

class BinaryNode<K extends Comparable<K>> {
    int key;
    BinaryNode<K> left;
    BinaryNode<K> right;

    public BinaryNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Welcome to the Program");
        BinaryTree<Integer> myTree = new BinaryTree<>();
        myTree.add(56);
        myTree.add(30);
        myTree.add(70);
        myTree.print(myTree.root);
    }
}
class BinaryTree <K extends Comparable<K>> {
    BinaryNode<K> root;

    public void add(int Key) {
        BinaryNode<K> newNode = new BinaryNode<K>(Key);
        if (root == null) {
            root = newNode;
            return;
        } else {
            BinaryNode<K> current = root;
            BinaryNode<K> parent = null;
            while (true) {
                parent = current;
                // if key less than root assigning to left
                if (Key < current.key) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                // Assigning key to right
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void print(BinaryNode<K> node) {
        if (node == null) {
            System.out.println("Tree is empty");
        } else {
            if (node.left != null)
                print(node.left);
            System.out.print(node.key + " ");
            if (node.right != null)
                print(node.right);

        }
    }
}

