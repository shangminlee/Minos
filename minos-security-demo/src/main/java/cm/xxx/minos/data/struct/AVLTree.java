package cm.xxx.minos.data.struct;

import java.io.IOException;
import java.util.Random;

/**
 * Description: 平衡树
 * Author: lishangmin
 * Created: 2018-08-20 17:55
 */
public class AVLTree<E extends Comparable> {

    private class TreeNode<E> {
        E element;

        TreeNode left,right;

        int factor;

        public TreeNode(E element) {
            this.element = element;
        }
        public TreeNode(E element,int factor) {
            this.element = element;
            this.factor = factor;
        }
    }

    private TreeNode root;

    private int size;

    public AVLTree() {
        this.size = 0;
    }

    public AVLTree(E[] elements){
        this.size = 0;
        for (E element: elements) {
            this.root = this.add(this.root,element);
        }
    }

    public void add(E element){
        this.root = this.add(this.root,element);
    }

    private TreeNode add(TreeNode treeNode,E element){
        if(treeNode == null){
            treeNode = new TreeNode<>(element,0);
            size++;
        }
        if(element.compareTo(treeNode.element) < 0){
            treeNode.left = add(treeNode.left,element);
        }else if(element.compareTo(treeNode.element) > 0){
            treeNode.right = add(treeNode.right,element);
        }
        treeNode.factor = this.getBalanceFactor(treeNode);

        //右子树比左子树大
        if(treeNode.factor < -1){
            return leftRotation(treeNode);
        }
        if (treeNode.factor < -1) {
            treeNode.right = rightRotation(treeNode.right);
            return leftRotation(treeNode);
        }

        if(treeNode.factor < -1 && this.getBalanceFactor(treeNode.left) <= 0){
            return leftRotation(treeNode);
        }
        if(treeNode.factor >  1 && this.getBalanceFactor(treeNode.right) >= 0){
            return rightRotation(treeNode);
        }

        if (treeNode.factor > 1 && this.getBalanceFactor(treeNode.left) < 0) {
            treeNode.left = leftRotation(treeNode.left);
            return rightRotation(treeNode);
        }

        if (treeNode.factor < -1 && getBalanceFactor(treeNode.right) > 0) {
            treeNode.right = rightRotation(treeNode.right);
            return leftRotation(treeNode);
        }

        return treeNode;
    }

    public int getBalanceFactor(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return this.depth(treeNode.left) - this.depth(treeNode.right);
    }

    public void remove(E element){
        this.root = remove(this.root,element);
    }

    public TreeNode remove(TreeNode treeNode,E element){
        if(treeNode == null){
            return null;
        }
        if(element.compareTo(treeNode.element) < 0){
            treeNode.left = remove(treeNode.left,element);
        }else if(element.compareTo(treeNode.element) > 0){
            treeNode.right = remove(treeNode.right,element);
        }else{
            if(treeNode.left == null){
                size--;
                return treeNode.right;
            }
            if(treeNode.right == null){
                size--;
                return treeNode.left;
            }
            TreeNode<E> min = this.findMin(treeNode.left);
            treeNode = remove(treeNode, min.element);
            min.left = treeNode.left;
            min.right = treeNode.right;
            treeNode = null;
            return min;
        }
        return treeNode;
    }

    public TreeNode findMax(){
        return this.findMax(this.root);
    }

    private TreeNode<E> findMax(TreeNode<E> treeNode){
        if(treeNode.right == null){
            return treeNode;
        }
        return findMax(treeNode.right);
    }

    public TreeNode findMin(){
        return this.findMin(this.root);
    }

    private TreeNode findMin(TreeNode treeNode){
        if(treeNode.left == null){
            return treeNode;
        }
        return findMax(treeNode.left);
    }

    public boolean contain(E element){
        return this.contain(this.root,element);
    }

    private boolean contain(TreeNode treeNode, E element){
        if(treeNode == null){
            return false;
        }
        if(element.compareTo(treeNode.element) < 0){
            return contain(treeNode.left,element);
        }
        if(element.compareTo(treeNode.element) > 0){
            return contain(treeNode.right,element);
        }
        return true;
    }

    public int depth() {
        return this.depth(this.root);
    }

    private int depth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return Math.max(depth(treeNode.left),depth(treeNode.right)) + 1;
    }

    private TreeNode rightRotation(TreeNode treeNode){
        TreeNode rotation = treeNode.left;
        TreeNode temp = rotation.right;
        rotation.right = treeNode;
        treeNode.left = temp;
        treeNode.factor = this.getBalanceFactor(rotation);
        return rotation;
    }

    private TreeNode leftRotation(TreeNode treeNode){
        TreeNode rotation = treeNode.right;
        TreeNode temp = rotation.left;
        rotation.left = treeNode;
        treeNode.right = temp;

        treeNode.factor = this.getBalanceFactor(rotation);
        return rotation;
    }

    private void printTree() throws Exception{
        this.printTree(this.root);
    }

    public void printTree(TreeNode treeNode) throws IOException {
        if (treeNode.right != null) {
            printTree(treeNode.right, true, "");
        }
        printNodeValue(treeNode);
        if (treeNode.left != null) {
            printTree(treeNode.left, false, "");
        }
    }
    private void printNodeValue(TreeNode treeNode) throws IOException {
        if (treeNode.element == null) {
            System.out.print("<null>");
        } else {
            System.out.print(treeNode.element.toString() + ":" + treeNode.factor);
        }
        System.out.print('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(TreeNode treeNode, boolean isRight, String indent) throws IOException {
        if (treeNode.right != null) {
            printTree( treeNode.right,true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(treeNode);
        if (treeNode.left != null) {
            printTree(treeNode.left,false, indent + (isRight ? " |      " : "        "));
        }
    }

    public static void main(String[] args) throws Exception{
        Random random = new Random();
//        AVLTree<Integer> avlTree = new AVLTree<>(new Integer[]{1,12,3,4,5});
//        AVLTree<Integer> avlTree = new AVLTree<>(new Integer[]{2,1,12,11,13,9});
        AVLTree<Integer> avlTree = new AVLTree<>();
        int count = 200;
        for(int i = 0 ; i < count ; i++){
            avlTree.add(i);
        }
        avlTree.printTree();

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        for(int i = 0 ; i < count ; i++){
            binaryTree.add(i);
        }
        binaryTree.printTree();


    }
}
