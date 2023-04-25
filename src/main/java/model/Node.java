package model;

public class Node {
    private Node left;
    private Node right;
    private int sum;

    public Node() {
        this.left = null;
        this.right = null;
        this.sum = 0;
    }

    public Node(Node left, Node right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    public Node(Node node) {
        this.left = node.left;
        this.right = node.right;
        this.sum = node.sum;
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}
