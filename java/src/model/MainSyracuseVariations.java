
package model;

import java.security.InvalidParameterException;
import java.util.*;

public class MainSyracuseVariations {
  public static void main(String[] args) {

    if (args.length != 2) {
      throw new InvalidParameterException(
      "Vous devez donner deux entiers (le nombre sur lequel trouver les variations, le coefficient a de la suite an+1), vous n'avez pas donné de paramètres."
      );
    }

    int nb;
    try {
      nb = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException(
      "Vous devez donner un entier sur lequel trouver le nombre de variations, vous avez donné : " + args[0]
      );
    }

    if (nb < 2) {
      throw new InvalidParameterException("L'entier doit être supérieur ou égal à 2, vous avez donné : " + nb);
    }

    int a;
    try {
      a = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier pour le coefficient a de an+1, vous avez donné : " + args[1]);
    }

    if (nb < 2) {
      throw new InvalidParameterException("Le coefficient doit être supérieur ou égal à 2, vous avez donné : " + nb);
    }

    Syracuse syra = new Syracuse(nb);
    System.out.println(Syracuse.getVariationsOf(nb, a));
  }
}
