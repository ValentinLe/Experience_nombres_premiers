
package gui;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.*;

public class ViewVariations extends JPanel {

  private java.util.List<Long> variations;
  private int widthSpace;
  private int heightGraph;
  private long maxValue;
  private int pointHover;

  public ViewVariations(java.util.List<Long> variations) {
    this.variations = variations;
    this.widthSpace = 10;
    this.heightGraph = 500;
    this.maxValue = Collections.max(variations);
    this.maxValue *= 1.05; // on augmente un peu la valeur pour pas qu'elle touche le haut
    this.pointHover = -1;
  }

  public void setHeightGraph(int newHeight) {
    this.heightGraph = newHeight;
  }

  public void setWidthSpace(int newWidthSpace) {
    this.widthSpace = newWidthSpace;
  }

  public void setNumberHover(int number) {
    this.pointHover = number;
  }

  public void drawLineBetween(Graphics2D g, int i, int vali, int i2, int vali2) {
    int firstValue = this.getHeightOfValue(vali);
    int secondValue = this.getHeightOfValue(vali2);
    // on trace un trait de 3 d'épaisseur
    g.setStroke(new BasicStroke(3));
    g.draw(new Line2D.Float(i*widthSpace, firstValue, i2*widthSpace, secondValue));
    g.setStroke(new BasicStroke(1));
  }

  public int getHeightOfValue(int value) {
    return this.heightGraph - value * this.heightGraph/((Long) this.maxValue).intValue();
  }

  @Override
  public void paintComponent(Graphics g) {
    Iterator<Long> iter = variations.iterator();
    int currentNb;
    int i = 0;
    g.setColor(new Color(3, 155, 229)); // bleu
    while (iter.hasNext()) {
      // on trace la courbe
      currentNb = iter.next().intValue();
      if (iter.hasNext()) {
	this.drawLineBetween((Graphics2D) g, i, currentNb, i+1, variations.get(i+1).intValue());
      }
      i++;
    }
    g.setColor(Color.black);
    if (0 <= pointHover && pointHover < variations.size()) {
      // si la souris est dans la zone du graphe
      int size = 10;
      int decal = size/2;
      g.fillOval(widthSpace * pointHover - decal, getHeightOfValue(variations.get(pointHover).intValue()) - decal, size, size);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
      g.drawString("x: " + pointHover, 5, 25);
      g.drawString("y: " + variations.get(pointHover), 5, 50);
    }
    g.drawLine(0, heightGraph, variations.size()*widthSpace, heightGraph);
  }

}
