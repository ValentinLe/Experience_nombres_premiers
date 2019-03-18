
package gui;

import utilitaire.MyMath;
import java.awt.*;
import javax.swing.*;
import model.*;

public class ViewUlam extends JPanel {

  private Board board;
  private int tileSize;

  public ViewUlam(Board board, int tileSize) {
    this.board = board;
    this.tileSize = tileSize;
  }

  @Override
  public void paintComponent(Graphics g) {
    int size = this.board.getSize();
    for (int j = 0; j < size; j++) {
      for (int i = 0; i < size; i++) {
      	Integer value = this.board.getValueAt(i, j);
        if (value != null) {
          if (MyMath.isPrime(value)) {
            g.setColor(Color.BLACK);
          } else {
            g.setColor(Color.WHITE);
          }
          g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
        }
      }
    }
  }
}
