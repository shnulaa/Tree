package test.liuyq.binarytree;

import java.util.Random;
import java.util.stream.IntStream;

public class BinaryTreeTest {

  private static final int ROOT_KEY = 50;

  private static TreeNode ROOT_NODE = new TreeNode(ROOT_KEY);

  /**
   * ×óÐ¡ ÓÒ´ó
   * 
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    BinaryTree binaryTree = new BinaryTree(ROOT_NODE);
    Random random = new Random();

    IntStream.rangeClosed(1, 20).forEach(i -> {
      int rad = random.nextInt(100);
      System.out.println(rad);
      binaryTree.insert(rad);
    });

    binaryTree.insert(34);

    // TreeNode treeNode = binaryTree.search(34);
    // System.out.println(treeNode.getLeft());
    // System.out.println(treeNode.getRight());


    // binaryTree.insert(random.nextInt());
    // binaryTree.insert(random.nextInt());
    // binaryTree.insert(random.nextInt());


    /* for (binaryTree.get) */

    System.out.println("---------------------------");
    // TreeNode node = ROOT_NODE;
    // while ((node = node.getLeft()) != null) {
    // if (node == null) {
    //
    // }
    //
    // TreeNode preNode = node;
    //
    // // System.out.println(node.getKey());
    // }
    TreeNode node = ROOT_NODE;

    // print2DUtil(node, 0);
    BTreePrinter.printTreeNode(node);
    // while (true) {
    // if ()
    //
    //
    // }

  }


  static final int COUNT = 10;

  static void print2DUtil(TreeNode root, int space) {
    // Base case
    if (root == null) return;

    // Increase distance between levels
    space += COUNT;

    // Process right child first
    print2DUtil(root.getRight(), space);

    // Print current node after space
    // count
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
      System.out.print(" ");
    System.out.print(root.getKey() + "\n");

    // Process left child
    print2DUtil(root.getLeft(), space);

  }

}
