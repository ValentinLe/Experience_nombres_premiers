
package utilitaire;

/**
 * Classe pour le test de primalité
 */
public class MyMath {

  /**
   * Test si le nombre est premier
   * @param number le nombre a tester
   * @return true si le nombre est premier
   */
  public static boolean isPrime(int number) {
    if (number < 4) {
      // 2 et 3 validés
      return 2 <= number;
    } else {
      // nombre pair
      if (isDivisible(number, 2)) {
	       return false;
      }
      // nombre impair
      for (int i = 3; i < (Math.sqrt(number) + 1); i += 2) {
      	if (isDivisible(number, i)) {
      	  return false;
      	}
      }
      return true;
    }
  }

  /**
   * Test si a est divisible par b
   * @param a le nombre a
   * @param b le nombre b
   * @return true si a est divisible par b
   */
  public static boolean isDivisible(long a, long b) {
    return Math.floorMod(a, b) == 0;
  }
}
