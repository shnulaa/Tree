package test.liuyq.binarytree;

/**
 * 
 * @author
 *
 */
public class TreeNode {

  static enum ParentSide {
    LEFT, RIGHT;
  }

  // private TreeNode parent; // 父
  private TreeNode left; // 左
  private TreeNode right; // 右
  private int key; // 数值
  private ParentSide parentSide; // 父节点 左 右

  /**
   * 
   */
  public TreeNode() {
  }

  /**
   * 
   * @param parent
   * @param left
   * @param right
   * @param key
   */
  public TreeNode(/* TreeNode parent, */ TreeNode left, TreeNode right, int key) {
    // this.parent = parent;
    this.left = left;
    this.right = right;
    this.key = key;
  }

  public TreeNode(int key) {
    this.key = key;
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

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public ParentSide getParentSide() {
    return parentSide;
  }

  public void setParentSide(ParentSide parentSide) {
    this.parentSide = parentSide;
  }


  /*
   * public TreeNode getParent() { return parent; }
   * 
   * public void setParent(TreeNode parent) { this.parent = parent; }
   */

}

