package cm.xxx.minos.data.struct;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-16 11:03
 */

public class TestBinaryTree {

    public static void main(String[] args) {
        testLevelOrder();
    }

    public static void testLevelOrder(){
        Integer[] arrays = {5,1,2,3,4,5,6,7,};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arrays);
        System.out.print("LevelOrder:");
        binaryTree.levelOrder();
        System.out.println(binaryTree.maxLevel());
        binaryTree.print();
    }
}
