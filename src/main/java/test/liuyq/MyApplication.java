package test.liuyq;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MyApplication extends Application {
  private static int title_i = 0;

  @Override
  public void start(Stage primaryStage) {
    BST<Integer> tree = new BST<>();
    // 面板，PDF中为view
    MyPanel myPanel = new MyPanel(tree);
    // 容器，PDF中为pane
    Group borderPane = new Group();
    TextFlow textFlow = new TextFlow();
    textFlow.setLayoutX(25);
    textFlow.setLayoutY(25);
    Text roleStar = new Text("");
    Text title = new Text("没有数字，等待输入。。。");
    Text roleEnd = new Text("");
    textFlow.getChildren().addAll(roleStar, title, roleEnd);
    // 盒子
    HBox hBox = new HBox();
    Text text_1 = new Text("请输入数字：");
    TextField text_2 = new TextField();
    Tooltip tooltip = new Tooltip();
    tooltip.setText("不要乱输哦~");
    text_2.setTooltip(tooltip);
    Button button_1 = new Button("插入");
    button_1.setOnAction(event -> {
      String text = text_2.getText();
      int textNum;
      if (!text.isEmpty()) {
        try {
          textNum = Integer.parseInt(text);
          if (textNum < 0 || textNum >= 100) {
            caveat("Please Enter Integers between ZERO to NINETY-NINE!", "请输入0~99之间的整数！");
          } else {
            if (!tree.search(textNum)) {
              title_i++;
              title.setFont(Font.loadFont("File:font/font.ttf", 15));
              roleStar.setText("旁白姬：“");
              title.setText("你悄悄地往树上扔了一个" + text_2.getText() + ",现在树中有" + title_i + "个数了哦！  :O");
              roleEnd.setText("”");
              tree.insert(textNum);
              myPanel.displayTree();
            } else {
              title.setText("你尝试在树上种下一颗果子，但没有成功，因为树上已经有这颗果子啦！  >_<");
            }
          }
        } catch (NumberFormatException e) {
          caveat("This Not Integer!", "这不是一个整数！");
        }
      } else {
        caveat("Do Not submit NULL values!", "请不要提交空值！");
      }
    });
    Button button_2 = new Button("删除");
    button_2.setOnAction(event -> {
      if (title_i - 1 >= 0) {
        int textNum = Integer.parseInt(text_2.getText());
        if (!tree.search(textNum)) {
          title.setText("你点了一下删除，但什么也没发生，因为树上没有这颗果子哦！  >_<");
        } else {
          tree.delete(textNum);
          title_i--;
          if (title_i == 0) {
            title.setText("你打了N个响指，树上的果子已经被清空了哦！  XD");
          } else {
            title.setText("你轻轻地按了一下删除，现在树中只有" + title_i + "个数了哦！  (〃＞＿＜;〃)");
          }
        }
        myPanel.displayTree();
      } else {
        title.setText("树上的果子已经被你摘完啦，再按也不会多一颗果子的！  (╬◣д◢)");
      }
    });
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(text_1, text_2, button_1, button_2);
    borderPane.getChildren().addAll(textFlow, hBox, myPanel);
    Scene s = new Scene(borderPane, 1000, 700);
    hBox.setLayoutX(s.getWidth() / 3.25);
    hBox.setLayoutY(s.getHeight() - 25);
    myPanel.setPrefWidth(s.getWidth());
    myPanel.setPrefHeight(s.getHeight() / 10);
    myPanel.setLayoutX(0);
    myPanel.setLayoutY(s.getHeight() / 10);
    primaryStage.setTitle("二叉树示例");
    primaryStage.setScene(s);
    primaryStage.show();
  }

  private void caveat(String content_1, String content_2) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("FBI Warning");
    alert.setHeaderText(content_1);
    alert.setContentText(content_2);
    alert.showAndWait();
  }
}
