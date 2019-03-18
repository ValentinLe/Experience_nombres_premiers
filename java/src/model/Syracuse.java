
package model;

import java.util.*;
import utilitaire.MyMath;

/**
 * Classe permettant de gérer la suite de Syracuse
 * si n pair, Un = n/2
 * si n impair, Un = 3n+1
 */
public class Syracuse {

  private long start;
  private long n;
  private Map<Long, Long> mapSyracuse;

  /**
   * Construit la suite de syracuse de 2 à n
   * @param n le nombre maximum de la suite
   */
  public Syracuse(long n) {
    this(n, 3);
  }

  /**
   * Construit une suite de syracuse de 2 à n avec le coefficient a pour les impairs
   * a*n + 1
   * @param n le nombre maximum de la suite
   * @param a le coefficient pour les impairs
   */
  public Syracuse(long n, int a) {
    this(2, n, a);
  }

  /**
   * Construit une suite de syracuse de 2 à n avec le coefficient a pour les impairs
   * a*n + 1
   * @param start le nombre de départ de la map
   * @param n le nombre maximum de la suite
   * @param a le coefficient pour les impairs
   */
  public Syracuse(long start, long n, int a) {
    this.start = start;
    this.n = n;
    this.mapSyracuse = this.getSyracuseMap(n, a);
  }

  /**
   * Getter sur la map de syracuse
   * @return la map de syracuse
   */
  public Map<Long, Long> getMapSyracuse() {
    return this.mapSyracuse;
  }

  /**
   * getter sur le nombre d'élément de la suite de syracuse
   * @return le nombre d'élément de la suite de syracuse
   */
  public long size() {
    return this.n - this.start + 1;
  }

  /**
   * getter sur le nombre de départ pour la suite de syracuse
   * @return le nombre de départ pour la suite de syracuse
   */
  public long getStart() {
    return this.start;
  }

  /**
   * Récupère le nombre d'itérations du nombre passé dans la map de syracuse
   * @param nb le nombre dont on veut le nombre d'itérations
   * @return le nombre d'itérations que le nombre a pris ou null si il n'est pas
   * dans la map
   */
  public Long getValueOf(long nb) {
    return this.mapSyracuse.get(nb);
  }

  /**
   * Créer la map de syracuse {nombre: nombres d'itérations} de 2 jusqu'à la borne
   * voulue
   * @param n le nombre maximum dont on veut connaitre le nombre d'itérations
   * @param a le coefficient de la variation impair a*n + 1
   * @return la map de syracuse
   */
  public Map<Long, Long> getSyracuseMap(long n, int a) {
    Map<Long, Long> mapSyra = new HashMap<>();
    for (long k = this.start; k < n+1; k++) {
      long temp = k; // valeur qui va varier avec 3n+1 ou n/2
      long cpt = 0; // compteur d'itérations calculées
      // qui servira à savoir si le nombre en sortie de boucle
      // est dans la map ou pas
      boolean inMap = false;
      while (temp != 1) {
      	cpt += 1;
      	temp = syracuse(temp, a);
      	if (mapSyra.containsKey(temp)) {
      	  // le temp est dans la map on arrete la boucle car on connait le resultat
      	  inMap = true;
      	  break;
      	}
      }
      if (inMap) {
      	// si le nombre temp à été détecté comme étant dans la map on va ajouté
      	// le nombre d'itérations calculées avec le nombre d'itérations que l'on
      	// connait déjà dans la map correspondant à la valeur de temp
      	mapSyra.put(k, cpt + mapSyra.get(temp));
      } else {
      	// le nombre n'est pas dans la map donc on l'ajoute avec le nombre d'itérations
      	// calculées
      	mapSyra.put(k, cpt);
      }
    }
    return mapSyra;
  }

  /**
   * Créer la map de syracuse {nombre: nombres d'itérations} de 2 jusqu'à la borne
   * voulue
   * @param n le nombre maximum dont on veut connaitre le nombre d'itérations
   * @return la map de syracuse
   */
  public Map<Long, Long> getSyracuseMap(long n) {
    return this.getSyracuseMap(n, 3);
  }

  /**
   * Récupére une liste des différentes variations éffectuer d'un nombre donné
   * exemple avec 8: [4,2,1]
   * @param n le nombre dont on veut les variations
   * @param a le coefficient de la variation impair de a*n + 1
   * @return une liste des différentes variations éffectuer
   */
  public static List<Long> getVariationsOf(long n, int a) {
    List<Long> variations = new ArrayList<>();
    long temp = n; // valeur qui va varier avec 3n+1 ou n/2
    variations.add(temp);
    while (temp != 1) {
      temp = syracuse(temp, a);
      variations.add(temp);
    }
    return variations;
  }

  /**
   * Récupére une liste des différentes variations éffectuer d'un nombre donné avec
   * le variation 3*n + 1 pour les impairs
   * exemple avec 8: [4,2,1]
   * @param n le nombre dont on veut les variations
   * @return une liste des différentes variations éffectuer
   */
  public static List<Long> getVariationsOf(long n) {
    return Syracuse.getVariationsOf(n, 3);
  }


  /**
   * Donne l'élément n+1 de la suite de syracuse
   * @param n l'élément n de la suite de syracuse
   * @param a le coefficient de la variation impair a*n + 1
   * @return l'élément n+1 de la suite de syracuse
   */
  public static long syracuse(long n, int a) {
    if (MyMath.isDivisible(n, 2)) {
      // nombre pair
      return n/2;
    } else {
      // nombre impair
      return a*n + 1;
    }
  }

  /**
   * Récupére le nombre qui à causé le plus d'itérations
   * @param mapSyracuse la map de syracuse pour récupérer le maximum
   * @return le nombre qui à causé le plus d'itérations
   */
  public long getMaxNumber(Map<Long, Long> mapSyracuse) {
    long maxIterations = Integer.MIN_VALUE;
    long nb = 0;
    for (Long i : mapSyracuse.keySet()) {
      long iterations = mapSyracuse.get(i);
      if (iterations > maxIterations) {
	maxIterations = iterations;
	nb = i;
      }
    }
    return nb;
  }

  /**
   * Récupére le nombre qui à causé le plus d'itérations en prenant la map de
   * l'objet this
   * @return le nombre qui à causé le plus d'itérations
   */
  public long getMaxNumber() {
    return this.getMaxNumber(this.mapSyracuse);
  }

  /**
   * Recupere la valeur maximale d'itérations atteinte par la suite
   * @return le nombre maximal d'itérations
   */
  public long getMaxIterations() {
    return this.getValueOf(this.getMaxNumber());
  }

  /**
   * Recupere la valeur maximale d'itérations atteinte dans la map donnée
   * @return le nombre maximal d'itérations
   */
  public long getMaxIterations(Map<Long, Long> mapSyra) {
    return this.getValueOf(this.getMaxNumber(mapSyracuse));
  }

  /**
   * Affichage en un certain nombre de colonnes les nombres avec leurs nombres
   * d'itérations
   * @return la réprésentation de la map de syracuse
   */
  @Override
  public String toString() {
    String ch = "";
    // longueur maximum sans qu'il y ait de décalages dans l'affichage de "n: nbIter"
    int lenMaxitem = 12;
    // nombre de colonnes souhaité
    int nbColumn = 5;
    int decal = (int) Math.floor((this.size()-2)/nbColumn) + 1;
    String item;
    for (long i = 2; i < decal+2; i++) {
      for (long j = i; j < this.size(); j += decal) {
	if (this.mapSyracuse.containsKey(j)) {
	  item = j + ": " + this.mapSyracuse.get(j);
	  ch += item;
	  // ajout du nombre d'espace nécessaire pour aligner la collonnes suivante
	  for (int k = 0; k < (lenMaxitem-item.length()); k++) {
	    ch += " ";
	  }
	}
      }
      ch += "\n";
    }
    return ch;
  }
}
