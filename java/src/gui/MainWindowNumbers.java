
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class MainWindowNumbers extends JFrame {

  private Syracuse syracuse;
  private ViewNumbers view;
  private int widthBar;

  public MainWindowNumbers(int start, int nb) {

    this.setPreferredSize(new Dimension(500, 500));

    this.syracuse = new Syracuse(start, nb, 3);

    this.setTitle("Suite de Syracuse");

    this.view = new ViewNumbers(this.syracuse);
    this.add(view);

    view.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {}

      @Override
      public void mouseMoved(MouseEvent e) {
      	int x = e.getX();
      	int nb = (int) Math.floor(x/widthBar) + start;
      	view.setNumberHover(nb);
      	repaint();
      }
    });

    pack();

    this.addComponentListener(new ComponentListener() {
      @Override
      public void componentResized(ComponentEvent e) {
      	resizeGraph();
      }

      @Override
      public void componentMoved(ComponentEvent e) {
      }

      @Override
      public void componentShown(ComponentEvent e) {
      }

      @Override
      public void componentHidden(ComponentEvent e) {
      }
    });

    this.setMinimumSize(new Dimension(500,500));
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
  }

  /**
   * Recalcule les valeurs de la fenetre et donne ces valeurs aux max de la vue
   */
  public void resizeGraph() {
    Insets insets = getInsets();
    int width = getSize().width - insets.left - insets.right;
    int height = getSize().height - getInsets().top - getInsets().bottom - 10;
    widthBar = (int) Math.floor(width/syracuse.size());
    view.setWidthBar(widthBar);
    view.setMaxHeightBar(height);
    this.repaint();
  }
}
