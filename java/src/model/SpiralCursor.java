
package model;

import utilitaire.*;

/**
 * Represente un curseur qui se deplace en spirale
 */
public class SpiralCursor extends Cursor {
  
  /**
   * Construit une instance de SpiralCursor
   * @param x la coordonnee X du curseur
   * @param y la coordonnee Y du curseur
   * @param dir la direction du curseur
   * @param board le tableau dans lequel se déplace le curseur
   */
  public SpiralCursor(int x, int y, Direction dir, Board board) {
    super(x, y, dir, board);
  }
  
  /**
   * Construit un curseur avec un board en le placent au centre de la grille
   * @param board le board qui permet de placer le cuseur
   * @return le curseur construit
   */
  public static SpiralCursor buildSpiralCursor(Board board) {
    int size = board.getSize();
    int addParity = (MyMath.isDivisible(size, 2) ? -1 : 0);
    int x = (int) Math.floor(size/2) + addParity;
    int y = x;
    return new SpiralCursor(x, y, Direction.RIGHT, board);
  }
  
  /**
   * Deplace le curseur
   */
  public void move() {
    this.x += this.dir.getX();
    this.y += this.dir.getY();
  }
  
  /**
   * Test si le curseur peut se deplacer dans la direction ou il se trouve
   * @return true si le curseur peut se deplacer
   */
  public boolean canMove() {
    return this.canMove(this.dir);
  }
  
  /**
   * Test si le curseur peut se deplacer en (x,y)
   * @param x la coordonnee X de la destination
   * @param y la coordonnee Y de la destination
   * @return true si le curseur peut se deplacer en (x,y)
   */
  public boolean canMove(int x, int y) {
    return this.board.isInIndex(x, y) && !this.board.isFill(x, y);
  }
  
  /**
   * Test si le curseur peut se deplacer dans la direction donnee
   * @param dir la direction du test
   * @return true si le curseur peut se deplacer dans la direction donnee
   */
  public boolean canMove(Direction dir) {
    int destX = this.x + dir.getX();
    int destY = this.y + dir.getY();
    return this.canMove(destX, destY);
  }
  
  /**
   * Tourne le curseur dans la direction dont il peut aller
   */
  public void turn() {
    Direction dirLeft = this.dir.turnLeft();
    if (canMove(dirLeft)) {
      this.dir = dirLeft;
    }
  }
  
  /**
   * Passe le curseur dans le prochain état 
   */
  @Override
  public void next() {
    this.move();
    this.turn();
  }
  
  /**
   * Renvoi une représentation sous forme de String du curseur
   * @return une représentation du curseur
   */
  @Override
  public String toString() {
    return "Cursor : " + this.x + ", " + this.y + " -> " + this.dir;
  }
  
}
