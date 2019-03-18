
package gui;

import java.security.InvalidParameterException;

public class MainUlam {
  public static void main(String[] args) {
    if (args.length != 3) {
      throw new InvalidParameterException(
      "Vous devez donner trois entiers (taille de la grille, valeur de départ de la spirale, taille des cases), vous n'avez pas donné le bon nombre de paramètres."
      );
    }

    int size;
    try {
      size = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier, vous avez donné : " + args[0]);
    }

    int startValue;
    try {
      startValue = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier pour la valeur de départ, vous avez donné : " + args[1]);
    }

    if (size < 1) {
      throw new InvalidParameterException("La taille doit être supérieur ou égal à 1, vous avez donné : " + size);
    }

    if (startValue < 1) {
      throw new InvalidParameterException("La valeur de départ doit être supérieur ou égal à 1, vous avez donné : " + startValue);
    }

    int tileSize;
    try {
      tileSize = Integer.parseInt(args[2]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier pour la taille des cases, vous avez donné : " + args[2]);
    }

    if (tileSize < 1) {
      throw new InvalidParameterException("La taille des cases doit être supérieur ou égal à 1, vous avez donné : " + tileSize);
    }

    new MainWindowUlam(size, startValue, tileSize);
  }
}
