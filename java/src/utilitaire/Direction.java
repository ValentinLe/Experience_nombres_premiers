
package utilitaire;

/**
 * Represente une direction
 */
public enum Direction {
  UP (0,-1),
  LEFT (-1,0),
  DOWN (0,1),
  RIGHT (1,0);

  private final int x;
  private final int y;

/**
  * Constructeur de la classe
  *  @param x , qui est un int.
  * @param y , qui est un int.
  */
  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
    * Retourne X
    * @return this.x
    */
  public int getX() {
    return this.x;
  }

  /**
    * Retourne Y
    * @return this.y
    */
  public int getY() {
    return this.y;
  }

  /**
    * Retourne la Direction apres avoir tourne a droite
    * @return la nouvelle direction
    */
  public Direction turnRight() {
    switch (this) {
      case UP:
        return RIGHT;
      case RIGHT:
        return DOWN;
      case DOWN:
        return LEFT;
      default:
        return UP;
    }
  }

  /**
    * Retourne la Direction apres avoir tourne a droite
    * @return la nouvelle direction
    */
  public Direction turnLeft() {
    switch (this) {
      case UP:
        return LEFT;
      case LEFT:
        return DOWN;
      case DOWN:
        return RIGHT;
      default:
        return UP;
    }
  }
  
  /**
   * Representation String de la direction
   * @return Representation String de la direction
   */
  @Override
  public String toString() {
    String ch = "dir: ";
    if (this == UP) {
      ch += "UP";
    } else if (this == DOWN) {
      ch += "DOWN";
    } else if (this == RIGHT) {
      ch += "RIGHT";
    } else {
      ch += "LEFT";
    }
    return ch;
  }
}
