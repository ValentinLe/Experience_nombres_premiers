
package model;

import java.security.InvalidParameterException;
import java.util.*;

public class MainSyracuseNumbers {
  public static void main(String[] args) {

    if (args.length != 1) {
      throw new InvalidParameterException(
      "Vous devez donner un entier (le nombre d'éléments dans la suite), vous n'avez pas donné de paramètres."
      );
    }

    int nb;
    try {
      nb = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException(
      "Vous devez donner un entier qui est le nombre d'éléments de la suite, vous avez donné : " + args[0]
      );
    }

    if (nb < 2) {
      throw new InvalidParameterException("L'entier doit être supérieur ou égal à 2, vous avez donné : " + nb);
    }

    Syracuse syra = new Syracuse(nb);
    System.out.println(syra);
  }
}
