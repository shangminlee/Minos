package cm.xxx.minos.data.struct;

import cm.xxx.minos.LinkedQueue;
import cm.xxx.minos.LinkedStack;
import cm.xxx.minos.Stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Description: 二叉树
 * Author: lishangmin
 * Created: 2018-08-13 10:14
 */
public class BinaryTree<E extends Comparable> {

    private class TreeNode {
        E e;
        TreeNode left;
        TreeNode right;
        public TreeNode(E e) {
            this.e = e;
        }
    }

    private TreeNode root;

    private int size;

    public BinaryTree() {
    }

    public BinaryTree(E[] elements){
        for (E element: elements) {
            this.root = this.add(this.root,element);
        }
    }

    public void add(E element){
        this.root = add(this.root,element);
    }

    public int getSize(){
        return size;
    }

    private TreeNode add(TreeNode treeNode, E element){
        if(treeNode == null){
            size++;
            return new TreeNode(element);
        }
        if (element.compareTo(treeNode.e) < 0){
            treeNode.left = add(treeNode.left,element);
        }else if (element.compareTo(treeNode.e) > 0){
            treeNode.right = add(treeNode.right,element);
        }
        return treeNode;
    }

    public void traversal(){
        this.traversal(this.root);
    }

    private void traversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        traversal(treeNode.left);
        System.out.println(treeNode.e);
        traversal(treeNode.right);
    }

    public void perOrder(){
        this.perOrder(this.root);
        System.out.println();
    }
    private void perOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.print(treeNode.e + " ");
        perOrder(treeNode.left);
        perOrder(treeNode.right);
    }

    public void perOrderStack(){
        this.perOrderStack(this.root);
    }

    private void perOrderStack(TreeNode treeNode){
        Stack<TreeNode> stack = new LinkedStack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.e+" ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        System.out.println("");
    }

    public void inOrder() throws Exception{
        this.inOrder(this.root);
        System.out.println();
    }
    private void inOrder(TreeNode treeNode) throws Exception{
        if(treeNode == null){
            return;
        }

        inOrder(treeNode.left);
        System.out.print(treeNode.e+" ");
        inOrder(treeNode.right);
    }

    public void postOrder(){
        this.postOrder(this.root);
        System.out.println();
    }
    private void postOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.e + " ");
    }

    private LinkedQueue<TreeNode> queue = new LinkedQueue<>();

    public void levelOrder(){
        queue.enqueue(this.root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.dequeue();
            System.out.print(treeNode.e+" ");
            if(treeNode.left != null){
                queue.enqueue(treeNode.left);
            }
            if(treeNode.right != null){
                queue.enqueue(treeNode.right);
            }
        }
        System.out.println(" ");
    }

    public boolean contains(E e){
        return this.contains(root,e);
    }

    private boolean contains(TreeNode treeNode, E e){
        if(treeNode == null) return false;
        if(e.compareTo(treeNode.e) == 0) return true;
        if(e.compareTo(treeNode.e) < 0){
            return contains(treeNode.left,e);
        }else{
            return contains(treeNode.right,e);
        }
    }

    public TreeNode minNode(){
        return this.minNode(this.root);
    }

    private TreeNode minNode(TreeNode treeNode){
        if(this.size == 0){
            throw new IllegalArgumentException("tree is empty");
        }
        if(treeNode.left == null){
            return treeNode;
        }
        return minNode(treeNode.left);
    }

    public TreeNode maxNode(){
        return this.maxNode(this.root);
    }
    private TreeNode maxNode(TreeNode treeNode){
        if(this.size == 0){
            throw new IllegalArgumentException("tree is empty");
        }
        if(treeNode.right == null){
            return treeNode;
        }
        return maxNode(treeNode.right);
    }

    public void removeMin(){
        this.root = this.removeMin(this.root);
    }

    private TreeNode removeMin(TreeNode treeNode){
        if(treeNode.left == null){
            TreeNode right = treeNode.right;
            treeNode.right = null;
            size--;
            return right;
        }
        treeNode.left = removeMin(treeNode.left);
        return treeNode;
    }

    public void removeMax(){
        this.root = this.removeMax(this.root);
    }

    public TreeNode removeMax(TreeNode treeNode){
        if(treeNode.right == null){
            TreeNode left = treeNode.left;
            treeNode.left = null;
            size--;
            return left;
        }
        treeNode.right = removeMax(treeNode.right);
        return treeNode;
    }

    public void remove(E e){
        this.root = this.remove(this.root,e);
    }

    private TreeNode remove(TreeNode treeNode,E e){
        if (size == 0){
            throw new IllegalArgumentException("tree is empty");
        }
        if(treeNode == null){
            return null;
        }
        if(e.compareTo(treeNode.e) < 0){
            treeNode.left = remove(treeNode.left,e);
            return treeNode;
        } else if(e.compareTo(treeNode.e) > 0){
            treeNode.right = remove(treeNode.right,e);
            return treeNode;
        }else {
            if(treeNode.left == null){
                size--;
                return treeNode.right;
            }
            if(treeNode.right == null){
                size--;
                return treeNode.left;
            }
            //找出左子树的最小节点
            TreeNode successor = minNode(treeNode.right);
            //用左子树的最小节点替换当前删除节点
            successor.right = removeMin(treeNode.right);
            successor.left = treeNode.left;
            return successor;
        }
    }

    public int maxLevel(){
        return this.maxLevel(this.root);
    }

    private int maxLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(this.maxLevel(node.left), this.maxLevel(node.right)) + 1;
    }

    public void print(){
        if(size == 0){
            return;
        }
        this.print(Arrays.asList(this.root),this.maxLevel(),1);
    }

    private void print(List<TreeNode> treeNodes, int maxLevel, int level){
        if (isAllElementsNull(treeNodes)){
            return;
        }
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2,(Math.max(floor-1,0)));
        int firstSpaces = (int) (Math.pow(2,floor) -1);
        int betweenSpaces = (int) (Math.pow(2,(floor + 1)) -1);

        this.printWhiteSpace(firstSpaces);
        List<TreeNode> newNodes = new ArrayList<>();
        for (int i = 0 ; i < treeNodes.size() ; i++) {
            TreeNode treeNode = treeNodes.get(i);
            if(treeNode != null){
                System.out.print(treeNode.e);
                newNodes.add(treeNode.left);
                newNodes.add(treeNode.right);
            }else{
                System.out.print("*");
                newNodes.add(null);
                newNodes.add(null);
            }
            if(i < treeNodes.size() - 1) {
                this.printSymbol(betweenSpaces);
            }
        }
        System.out.println(" ");

        print(newNodes,maxLevel,level+1);
    }

    private void printWhiteSpace(int count){
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    private void printSymbol(int count){
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    public void printTree() throws Exception{
        this.printTree(this.root);
    }

    private void printTree(TreeNode treeNode) throws IOException {
        if (treeNode.right != null) {
            printTree(treeNode.right, true, "");
        }
        printNodeValue(treeNode);
        if (treeNode.left != null) {
            printTree(treeNode.left, false, "");
        }
    }
    private void printNodeValue(TreeNode treeNode) throws IOException {
        if (treeNode.e == null) {
            System.out.print("<null>");
        } else {
            System.out.print(treeNode.e.toString());
        }
        System.out.print('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(TreeNode treeNode,boolean isRight, String indent) throws IOException {
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(this.root, 0, res);
        return res.toString();
    }

    public void generateBSTString(TreeNode treeNode, int depth, StringBuilder sb){
        if(treeNode == null){
            sb.append(generateDepthString(depth)).append("null \n");
            return;
        }
        sb.append(generateDepthString(depth)).append(treeNode.e).append("\n");
        generateBSTString(treeNode.left,depth+1,sb);
        generateBSTString(treeNode.right,depth+1,sb);
    }

    public String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public void toArray(){
        List<List<TreeNode>> lists = new ArrayList<>();
        this.toArray(Arrays.asList(this.root),lists);
        int depth = lists.size();
        System.out.println("深度："+depth);
        for (List<TreeNode> treeNodes : lists){
            for (TreeNode treeNode : treeNodes){

                if(treeNode != null){
                    System.out.print(treeNode.e+ " ");
                }else{
                    System.out.print("* ");
                }
            }
            depth--;
            System.out.println();
        }
    }

    public void toArray(List<TreeNode> treeNodes,List<List<TreeNode>> lists){
        if (isAllElementsNull(treeNodes)){
            return;
        }
        lists.add(treeNodes);
        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode t :treeNodes) {
            if(t!= null) {
                newNodes.add(t.left);
                newNodes.add(t.right);
            }else {
                newNodes.add(null);
                newNodes.add(null);
            }
        }
        toArray(newNodes,lists);
    }


    /**
     *       A
     *     /   \
     *    B    C
     *   / \  / \
     *  D  E F  G
     *
     */
    public static void main(String[] args) throws Exception{
        Integer[] elements = {10,11,1,6,7,8,9,12,13,45};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(elements);
        binaryTree.printTree();

        System.out.println("---------------------------------------------------------------------");

        String[] strs = {"apple","pen","orange","banana","peach"};
        BinaryTree<String> dicTree = new BinaryTree<>(strs);
        dicTree.printTree();

        System.out.println("---------------------------------------------------------------------");

        dicTree.remove("orange");
        dicTree.printTree();


        //search
        BinaryTree<Integer> searchTree = new BinaryTree<>();
        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            int num = random.nextInt(50);
            System.out.print(num+" ");
            searchTree.add(num);
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------");


        searchTree.printTree();
        searchTree.toArray();

        searchTree.out(searchTree);

        System.out.println("---------------------------------------------------------------------");

        System.out.println("min:"+ searchTree.minNode().e);
        System.out.println("max:"+ searchTree.maxNode().e);

        System.out.println("---------------------------------------------------------------------");
        searchTree.removeMin();

        searchTree.out(searchTree);
        System.out.println("---------------------------------------------------------------------");
        searchTree.removeMax();

        searchTree.out(searchTree);
        System.out.println("---------------------------------------------------------------------");

        searchTree.toArray();
    }

    public void out(BinaryTree binaryTree) throws Exception{
        System.out.print("PerOrder     : ");
        binaryTree.perOrder();
        System.out.print("PerOrderStack: ");
        binaryTree.perOrderStack();
        System.out.print("InOrder      : ");
        binaryTree.inOrder();
        System.out.print("PostOrder    : ");
        binaryTree.postOrder();
        System.out.print("LevelOrder   : ");
        binaryTree.levelOrder();
    }
}
