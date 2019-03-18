
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import model.*;

public class MainWindowVariations extends JFrame {

  private java.util.List<Long> variations;
  private int spacePoints;
  private ViewVariations view;

  public MainWindowVariations(int nb) {

    this.setTitle("Variations de la suite de Syracuse sur " + nb);

    variations = Syracuse.getVariationsOf(nb);
    
    view = new ViewVariations(variations);

    view.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {}

      @Override
      public void mouseMoved(MouseEvent e) {
      	int x = e.getX() + spacePoints/2;
      	int nb = (int) Math.floor(x/spacePoints);
      	view.setNumberHover(nb);
      	repaint();
      }
    });

    this.add(view);
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
    spacePoints = (int) Math.floor(width/variations.size());
    view.setWidthSpace(spacePoints);
    view.setHeightGraph(height);
    this.repaint();
  }
}
