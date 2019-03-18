
package model;

import utilitaire.Direction;

/**
 * Represente un curseur qui pointe sur une coordonnee et se déplace dans une
 * direction
 */
public abstract class Cursor {
  
  protected int x;
  protected int y;
  protected Direction dir;
  protected Board board;
  
  /**
   * Construit une instance de curseur
   * @param x la coordonnee X du curseur
   * @param y la coordonnee Y du curseur
   * @param dir la direction du curseur
   * @param board le tableau ou se trouvera le curseur
   */
  public Cursor(int x, int y, Direction dir, Board board) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.board = board;
  }

  /**
   * Getter sur la coordonnee X du curseur
   * @return la coordonnee X du curseur
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * Getter sur la coordonnee Y du curseur
   * @return la coordonnee Y du curseur
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * Getter sur la direction du curseur
   * @return la direction du curseur
   */
  public Direction getDirection() {
    return this.dir;
  }
  
  public abstract boolean canMove();
  
  /**
   * Passe le curseur dans le prochain état 
   */
  public abstract void next();
}
