//package test.liuyq;
//
//public class BinaryTreeTest {
//
//  /**
//   * 左小 右大
//   * 
//   * @param args
//   */
//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//
//  }
//
//  static class BinaryTree {
//
//    private TreeNode mRoot;
//
//    public BinaryTree(TreeNode root) {
//      this.mRoot = root;
//    }
//
//    public TreeNode search(int key) {
//      return search(mRoot, key);
//    }
//
//    /**
//     * 
//     * @param key
//     */
//    private void insert(int key) {
//      if (mRoot == null) {
//        TreeNode treeNode = new TreeNode();
//        treeNode.setKey(key);
//        return;
//      }
//    }
//
//    /**
//     * 
//     * @param treeNode
//     * @param key
//     * @return
//     */
//    private TreeNode insert(TreeNode parent, TreeNode treeNode, int key) {
//      
//      if (key < treeNode.getKey()) {
//        return search(treeNode.getLeft(), key);
//      } else {
//        return search(treeNode.getRight(), key);
//      }
//      
//
//      return null;
//    }
//
//
//
//    /**
//     * 
//     * @param BinaryTreeNode
//     */
//    private TreeNode search(TreeNode treeNode, int key) {
//      if (treeNode == null || treeNode.getKey() == key) {
//        return treeNode;
//      }
//
//      if (key < treeNode.getKey()) {
//        return search(treeNode.getLeft(), key);
//      } else {
//        return search(treeNode.getRight(), key);
//      }
//    }
//  }
//
//
//
//  /**
//   * 
//   * @author Administrator
//   *
//   */
//  static class TreeNode {
//    private TreeNode parent; // 父
//    private TreeNode left; // 左
//    private TreeNode right; // 右边
//    private int key; // 数值
//    private Object object; // 保存的内容
//
//    public TreeNode getLeft() {
//      return left;
//    }
//
//    public void setLeft(TreeNode left) {
//      this.left = left;
//    }
//
//    public TreeNode getRight() {
//      return right;
//    }
//
//    public void setRight(TreeNode right) {
//      this.right = right;
//    }
//
//    public int getKey() {
//      return key;
//    }
//
//    public void setKey(int key) {
//      this.key = key;
//    }
//
//    public Object getObject() {
//      return object;
//    }
//
//    public void setObject(Object object) {
//      this.object = object;
//    }
//
//    public TreeNode getParent() {
//      return parent;
//    }
//
//    public void setParent(TreeNode parent) {
//      this.parent = parent;
//    }
//
//  }
//
//}
