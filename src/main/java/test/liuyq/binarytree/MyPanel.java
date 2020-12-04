package test.liuyq.binarytree;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

@SuppressWarnings("restriction")
class MyPanel extends Pane {
  private BinaryTree tree;// = new BST<>();
  private double vGap = 50;

  MyPanel(BinaryTree tree) {
    this.tree = tree;
  }

  void displayTree() {
    this.getChildren().clear();
    if (tree.getRoot() != null) {
      displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
    }
  }

  // @SuppressWarnings("rawtypes")
  private void displayTree(TreeNode node, double x, double y, double hGap) {
    if (node.getLeft() != null) {
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      displayTree(node.getLeft(), x - hGap, y + vGap, hGap / 2);
    }
    if (node.getRight() != null) {
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      displayTree(node.getRight(), x + hGap, y + vGap, hGap / 2);
    }
    double radius = 15;
    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    getChildren().addAll(circle, new Text(x - 4, y + 4, node.getKey() + ""));
  }
}
