package test.liuyq.binarytree;

import test.liuyq.binarytree.TreeNode.ParentSide;

/**
 * 
 * @author Administrator
 *
 */
public class BinaryTree {
  private TreeNode root;



  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  public BinaryTree() {
  }

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
   * 1. 如果root节点的数值 = key,直接删除 <br>
   * 2. 根据key 查询到对应的父节点，如果父节点为空 ？？<br>
   * 2. 根据key 查询 自节点 如果查询不到退出<br>
   * 3. 根据要删除的节点 获取左节点不为空， 右节点为空，则直接将 父节点的左节点设置为 将要删除节点的左节点<br>
   * 4. 根据要删除的节点 获取右节点不为空， 左节点为空，则直接将 父节点的右节点设置为 将要删除节点的右节点<br>
   * 5. 根据要删除的节点 获取右节点不为空， 左节点不为空， 则 删除节点 的 右数 的 最小 左节点上位
   * 
   * @param key
   */
  public void delete(int key) {
    if (root == null || root.getKey() == key) {
      root = null;
      return;
    }

    // 根据key 查询 该key所在的父节点
    TreeNode parent = searchParent(key);
    if (parent == null) {
      return;
    }

    // 根据父节点和 key 查询 将要被删除的节点
    TreeNode current = searchCurrent(parent, key);
    if (current == null) {
      return;
    }

    // TreeNode parnetLeft = parent.getLeft(); // 父节点 的左节点
    // TreeNode parentRight = parent.getRight(); // 父节点的 右节点

    TreeNode left = current.getLeft(); // 当前被删除节点的 子左节点
    TreeNode right = current.getRight(); // 当前被删除节点的 子右节点
    // 当前被删除的节点 已经没有左右节点的情况下
    if (left == null && right == null) {
      // 寻找父节点 到底是左 还是 右 然后将 父节点的 左或者右 节点清空 ！
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(null);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(null);
      }
      current = null;
      return;
    } else if (left != null && right == null) {
      // 没有右节点的情况下，单纯 左节点
      // 则直接将 父节点的左节点设置为 将要删除节点的左节点
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(left);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(left);
      }
      current = null;
      return;
    } else if (left == null && right != null) {
      // 没有左节点的情况下，单纯 右节点
      // 则直接将 父节点的右节点设置为 将要删除节点的右节点
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(right);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(right);
      }
      current = null;
      return;
    } else {
      // 左右节点 都存在的情况下 则 删除节点 的 右数 的 最小 左节点上位
      TreeNode heroNode = current.getRight(); // 将要替换的英雄节点
      // 已经是最小的 直接上位
      if (heroNode.getLeft() == null) {
        // FIXME 上位的 英雄节点必须要继承 原来 的左节点！！！！！！！ 在没有左节点的情况下
        heroNode.setLeft(current.getLeft());
      } else {
        // 存在左节点的情况下，需要找到 改左节点 最小的 节点。
        TreeNode node = null;
        TreeNode preNode = null;
        while (((node = heroNode.getLeft()) != null) && (node.getLeft() == null)) {
          preNode = node;
          break;
        }
        heroNode.setLeft(current.getLeft());
        heroNode.setRight(current.getRight());
        heroNode.setKey(node.getKey());
        if (preNode != null) {
          preNode.setLeft(null);
          preNode.setRight(node.getRight());
        }
      }
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(heroNode);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(heroNode);
      }
      current = null;
      return;

    }



  }

  /**
   * 
   * @param parent
   * @param key
   * @return
   */
  public TreeNode searchCurrent(TreeNode parent, int key) {
    TreeNode left = parent.getLeft();
    TreeNode right = parent.getRight();

    if (left != null && left.getKey() == key) {
      left.setParentSide(ParentSide.LEFT);
      return left;
    } else if (right != null && right.getKey() == key) {
      right.setParentSide(ParentSide.RIGHT);
      return right;
    }
    return null;
  }



  /**
   * 
   * @param node
   * @param key
   * @return
   */
  public TreeNode searchParent(int key) {
    return searchParent(null, root, key);
  }

  /**
   * 
   * @param parent
   * @param node   param key
   */
  public TreeNode searchParent(TreeNode parent, TreeNode node, int key) {
    if (node == null) {
      return null;
    }

    if (parent != null && key == parent.getKey()) {
      // System.out.println(String.format("key:%s 已经存在， 不进行插入操作", key));
      return parent;
    } else if (key < node.getKey()) {
      return searchParent(node, node.getLeft(), key);
    } else {
      return searchParent(node, node.getRight(), key);
    }

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
   * @param parent
   * @param node   param key
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
      if (root == null) {
        root = node;
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
