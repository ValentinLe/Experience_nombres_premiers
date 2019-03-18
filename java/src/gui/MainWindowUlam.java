
package gui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class MainWindowUlam extends JFrame {

  private Board board;

  public MainWindowUlam(int size, int startValue, int tileSize) {

    this.setTitle("Ulam Spiral");

    this.board = new Board(size, startValue);

    ViewUlam view = new ViewUlam(board, tileSize);
    this.add(view);

    pack();

    this.setMinimumSize(new Dimension(300,300));
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
  }
}
