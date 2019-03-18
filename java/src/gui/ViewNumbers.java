
package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.*;

public class ViewNumbers extends JPanel {

  private Syracuse syracuse;
  private int widthBar;
  private int maxHeightBar;
  private int maxValue;
  private int numberHover;

  public ViewNumbers(Syracuse syra) {
    this.syracuse = syra;
    this.widthBar = 10;
    this.maxValue = ((Long) this.syracuse.getMaxIterations()).intValue();
    this.maxValue *= 1.05;
    this.maxHeightBar = 500;
    this.numberHover = 5;
  }

  public void setWidthBar(int newWidth) {
    this.widthBar = newWidth;
  }

  public void setMaxHeightBar(int newHeight) {
    this.maxHeightBar = newHeight;
  }

  public void setNumberHover(int number) {
    this.numberHover = number;
  }

  /**
   * Trace une une bar d'une couleur donnée selon la coordonnée et son nombre d'itérations
   * @param g le context de dessin
   * @param coord la coordonnée en X (dans la map des valeurs)
   * @param value son nombre d'itérations dans la map
   * @param color la couleur dans laquelle tracer la bar
   */
  public void drawBar(Graphics g, int coord, int value, Color color) {
    int heightBar = this.getHeightOfValue(value);
    // trace la bar transparante et le contour en pleine opacité
    g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 51));
    g.fillRect(this.widthBar*(coord-(int) syracuse.getStart()), this.maxHeightBar - heightBar, this.widthBar, heightBar);
    g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255));
    g.drawRect(this.widthBar*(coord-(int) syracuse.getStart()), this.maxHeightBar - heightBar, this.widthBar, heightBar);
  }

  /**
   * Trace une une bar bleu donnée selon la coordonnée et son nombre d'itérations
   * @param g le context de dessin
   * @param coord la coordonnée en X (dans la map des valeurs)
   * @param value son nombre d'itérations dans la map
   */
  public void drawBar(Graphics g, int coord, int value) {
    Color color = new Color(3, 169, 244);
    this.drawBar(g, coord, value, color);
  }

  /**
   * Donne la hauteur de la valeur donnée dans le graphe
   * @param value la valeur dans on veut la hauteur
   * @return la hauteur dans le référenciel du graph
   */
  public int getHeightOfValue(int value) {
    // on fait un produit en croix pour trouver la hauteur de notre valeur
    // sachant que la valeur maximum possède la hauteur maximum du graph
    int heightBar = value*this.maxHeightBar/maxValue;
    return heightBar;
  }

  @Override
  public void paintComponent(Graphics g) {
    Map<Long, Long> mapSyra = this.syracuse.getMapSyracuse();
    for (Long i : mapSyra.keySet()) {
      // on trace les bars du graph en bleu
      if (i != this.numberHover) {
      	this.drawBar(g, i.intValue(), mapSyra.get(i).intValue());
      }
    }
    if (mapSyra.containsKey((long) this.numberHover)) {
      // si la valeur survolé est dans la map on la dessine une bar rouge et
      // on indique la valeur survolé ainsi que son nombre d'itérations
      g.setColor(Color.black);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
      g.drawString("n = " + this.numberHover, 5, 25);
      g.drawString("it = " + mapSyra.get((long) this.numberHover), 5, 50);
      this.drawBar(g, numberHover, mapSyra.get((long) numberHover).intValue(), new Color(244, 67, 54));
    }
  }
}
