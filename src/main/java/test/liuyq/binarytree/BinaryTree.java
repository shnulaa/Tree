package test.liuyq.binarytree;

/**
 * 
 * @author Administrator
 *
 */
public class BinaryTree {
  private TreeNode root;

  /**
   * 
   * @param root
   */
  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  /**
   * 
   * @param key
   * @return
   */
  public TreeNode search(int key) {
    return search(root, key);
  }

  /**
   * 
   * @param node
   * @param key
   * @return
   */
  public TreeNode search(TreeNode node, int key) {
    if (node == null || node.getKey() == key) {
      return node;
    }

    if (key < node.getKey()) {
      return search(node.getLeft(), key);
    } else if (key > node.getKey()) {
      return search(node.getRight(), key);
    }
    return null;
  }

  /**
   * 
   * @param key
   */
  public void insert(int key) {
    insert(null, root, key);
  }

  /**
   * 
   * @param key
   */
  public void delete(int key) {
    



  }
//
//  /**
//   * 
//   * @param node 递归
//   * @param key
//   */
//  public void delete(TreeNode node, int key) {
//    // 最后删除实现条件 
//    if (node == null || node.getKey() == key) {
//
//
//    }
//
//  }



  /**
   * 
   * @param parent
   * @param node
   * @param key
   */
  public TreeNode insert(TreeNode parent, TreeNode node, int key) {
    if (node == null) {
      node = new TreeNode(/* parent, */ null, null, key);
      if (parent != null) {
        if (key < parent.getKey()) {
          parent.setLeft(node);
        } else if (key > parent.getKey()) {
          parent.setRight(node);
        }
      }
      return node;
    }

    if (key == node.getKey()) {
      System.out.println(String.format("key:%s 已经存在， 不进行插入操作", key));
      return node;
    } else if (key < node.getKey()) {
      return insert(node, node.getLeft(), key);
    } else {
      return insert(node, node.getRight(), key);
    }

  }



}
