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
   * 1. ���root�ڵ����ֵ = key,ֱ��ɾ�� <br>
   * 2. ����key ��ѯ����Ӧ�ĸ��ڵ㣬������ڵ�Ϊ�� ����<br>
   * 2. ����key ��ѯ �Խڵ� �����ѯ�����˳�<br>
   * 3. ����Ҫɾ���Ľڵ� ��ȡ��ڵ㲻Ϊ�գ� �ҽڵ�Ϊ�գ���ֱ�ӽ� ���ڵ����ڵ�����Ϊ ��Ҫɾ���ڵ����ڵ�<br>
   * 4. ����Ҫɾ���Ľڵ� ��ȡ�ҽڵ㲻Ϊ�գ� ��ڵ�Ϊ�գ���ֱ�ӽ� ���ڵ���ҽڵ�����Ϊ ��Ҫɾ���ڵ���ҽڵ�<br>
   * 5. ����Ҫɾ���Ľڵ� ��ȡ�ҽڵ㲻Ϊ�գ� ��ڵ㲻Ϊ�գ� �� ɾ���ڵ� �� ���� �� ��С ��ڵ���λ
   * 
   * @param key
   */
  public void delete(int key) {
    if (root == null || root.getKey() == key) {
      root = null;
      return;
    }

    // ����key ��ѯ ��key���ڵĸ��ڵ�
    TreeNode parent = searchParent(key);
    if (parent == null) {
      return;
    }

    // ���ݸ��ڵ�� key ��ѯ ��Ҫ��ɾ���Ľڵ�
    TreeNode current = searchCurrent(parent, key);
    if (current == null) {
      return;
    }

    // TreeNode parnetLeft = parent.getLeft(); // ���ڵ� ����ڵ�
    // TreeNode parentRight = parent.getRight(); // ���ڵ�� �ҽڵ�

    TreeNode left = current.getLeft(); // ��ǰ��ɾ���ڵ�� ����ڵ�
    TreeNode right = current.getRight(); // ��ǰ��ɾ���ڵ�� ���ҽڵ�
    // ��ǰ��ɾ���Ľڵ� �Ѿ�û�����ҽڵ�������
    if (left == null && right == null) {
      // Ѱ�Ҹ��ڵ� �������� ���� �� Ȼ�� ���ڵ�� ������� �ڵ���� ��
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(null);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(null);
      }
      current = null;
      return;
    } else if (left != null && right == null) {
      // û���ҽڵ������£����� ��ڵ�
      // ��ֱ�ӽ� ���ڵ����ڵ�����Ϊ ��Ҫɾ���ڵ����ڵ�
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(left);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(left);
      }
      current = null;
      return;
    } else if (left == null && right != null) {
      // û����ڵ������£����� �ҽڵ�
      // ��ֱ�ӽ� ���ڵ���ҽڵ�����Ϊ ��Ҫɾ���ڵ���ҽڵ�
      if (current.getParentSide() == ParentSide.LEFT) {
        parent.setLeft(right);
      } else if (current.getParentSide() == ParentSide.RIGHT) {
        parent.setRight(right);
      }
      current = null;
      return;
    } else {
      // ���ҽڵ� �����ڵ������ �� ɾ���ڵ� �� ���� �� ��С ��ڵ���λ
      TreeNode heroNode = current.getRight(); // ��Ҫ�滻��Ӣ�۽ڵ�
      // �Ѿ�����С�� ֱ����λ
      if (heroNode.getLeft() == null) {
        // FIXME ��λ�� Ӣ�۽ڵ����Ҫ�̳� ԭ�� ����ڵ㣡������������ ��û����ڵ�������
        heroNode.setLeft(current.getLeft());
      } else {
        // ������ڵ������£���Ҫ�ҵ� ����ڵ� ��С�� �ڵ㡣
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
      // System.out.println(String.format("key:%s �Ѿ����ڣ� �����в������", key));
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
      System.out.println(String.format("key:%s �Ѿ����ڣ� �����в������", key));
      return node;
    } else if (key < node.getKey()) {
      return insert(node, node.getLeft(), key);
    } else {
      return insert(node, node.getRight(), key);
    }

  }



}
