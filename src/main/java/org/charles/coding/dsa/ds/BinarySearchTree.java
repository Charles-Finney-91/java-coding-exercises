package org.charles.coding.dsa.ds;

import com.sun.source.tree.Tree;

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(bst.getRoot(), new TreeNode(5));
        bst.insert(bst.getRoot(),new TreeNode(7));
        bst.insert(bst.getRoot(),new TreeNode(1));
        bst.insert(bst.getRoot(),new TreeNode(3));
        bst.inOrderTraversal(bst.getRoot());
    }

    private void insert(TreeNode root, TreeNode newNode){
        if (root == null)
            root = newNode;
        else {
            if (newNode.getData() < root.getData())
                insert(root.getLeft(), newNode);
            else if (newNode.getData() > root.getData())
                insert(root.getRight(), newNode);
        }
    }

    private void inOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRight());
    }
}

class TreeNode{
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
