
package gui;

import java.security.InvalidParameterException;

public class MainSyracuseNumbers {
  public static void main(String[] args) {

    int argc = 0;
    int start = 2;

    if (args.length != 1 && args.length != 2) {
      throw new InvalidParameterException("Vous devez donner un entier ou (entier départ, entier arrivé), vous n'avez pas donné le bon nombre de paramètres.");
    }

    if (args.length == 2) {
      try {
        start = Integer.parseInt(args[argc]);
        argc += 1;
      } catch (NumberFormatException e) {
        throw new InvalidParameterException("Vous devez donner un entier pour le départ, vous avez donné : " + args[argc]);
      }

      if (start < 2) {
        throw new InvalidParameterException("Le nombre de départ doit etre supérieur ou égal à 2, vous avez donné : " + args[argc-1]);
      }
    }

    int nb;
    try {
      nb = Integer.parseInt(args[argc]);
      argc += 1;
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier, vous avez donné : " + args[argc]);
    }

    if (nb < 2) {
      throw new InvalidParameterException("L'entier doit être supérieur ou égal à 2, vous avez donné : " + nb);
    }

    new MainWindowNumbers(start, nb);
  }
}
