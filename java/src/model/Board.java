
package model;

/**
 * Represente un tableau de nombre
 */
public class Board {

  private int size;
  private int startValue;
  private Integer[][] grid;

  /**
   * Construit la spirale d'Ulam
   * @param size la dimention du tableau
   * @param startValue la valeur de départ de la spirale
   */
  public Board(int size, int startValue) {
    this.size = size;
    this.startValue = startValue;
    this.resetSpirale();
  }

  /**
   * Construit/reconstruit la spirale
   */
  public void resetSpirale() {
    this.grid = initGrid();
    this.placeNumbers(SpiralCursor.buildSpiralCursor(this));
  }

  /**
   * Contruit le tableau d'entiers vide de la largeur et la hauteur de la classe
   * @return le tableau initialise
   */
  public Integer[][] initGrid() {
    Integer[][] gridRes = new Integer[size][size];
    return gridRes;
  }

  /**
   * Place les nombres en forme de spirale dans la grille
   * @param cursor le curseur a suivre pour le remplissage
   */
  public void placeNumbers(Cursor cursor) {
    int nb = startValue;
    this.setValueAt(cursor.getX(), cursor.getY(), nb);
    while (nb < size * size + startValue && cursor.canMove()) {
      nb++;
      cursor.next();
      this.setValueAt(cursor.getX(), cursor.getY(), nb);
    }
  }

  /**
   * Test si en (x,y) la case a ete remplie
   * @param x la coordonnee X
   * @param y la coordonnee Y
   * @return true si la case (x, y) à un nombre différent de null
   */
  public boolean isFill(int x, int y) {
    return this.getValueAt(x, y) != null;
  }

  /**
   * Test si la coordonnee (x,y) est dans la grille
   * @param x la coordonnee X
   * @param y la coordonne Y
   * @return true si la coordonnee (x,y) est dans la grille
   */
  public boolean isInIndex(int x, int y) {
    return 0 <= x && x < this.size && 0 <= y && y < this.size;
  }

  /**
   * Recupere la valeur en (x,y)
   * @param x la coordonnee X
   * @param y la coordonnee Y
   * @return la valeur en (x,y)
   */
  public Integer getValueAt(int x, int y) {
    return this.grid[y][x];
  }

  /**
   * Modifie la valeur en (x,y)
   * @param x la coordonnee X
   * @param y la coordonnee Y
   * @param value la nouvelle valeur a affecter
   */
  public void setValueAt(int x, int y, int value) {
    this.grid[y][x] = value;
  }

  /**
   * Getter sur la dimention de la grille
   * @return la dimention de la grille
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Affichage en String de la grille
   * @return la representation de la grille
   */
  @Override
  public String toString() {
    String ch = "";
    String tmp;
    for (int j = 0; j < size; j++) {
      for (int i = 0; i < size; i++) {
      	tmp = this.getValueAt(i, j) + "";
      	for (int k = 0; k < (5-tmp.length()); k++) {
      	  ch += " ";
      	}
      	ch += tmp;
      }
      ch += "\n";
    }
    return ch;
  }
}
