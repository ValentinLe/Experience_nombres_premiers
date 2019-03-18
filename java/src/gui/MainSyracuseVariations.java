
package gui;

import java.security.InvalidParameterException;

public class MainSyracuseVariations {
  public static void main(String[] args) {

    if (args.length != 1) {
      throw new InvalidParameterException("Vous devez donner un entier, vous n'avez pas donné le bon nombre de paramètres.");
    }

    int nb;
    try {
      nb = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      throw new InvalidParameterException("Vous devez donner un entier, vous avez donné : " + args[0]);
    }

    if (nb < 3) {
      throw new InvalidParameterException("L'entier doit être supérieur ou égal à 3, vous avez donné : " + nb);
    }

    new MainWindowVariations(nb);
  }
}
