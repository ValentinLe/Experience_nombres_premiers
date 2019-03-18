scripts :

    >>> tous les scripts run* compile avant d'exécuter leur classe
    
    # Ulam
    
        - sh runGuiUlam.sh [taille grille] [valeur départ] [taille des cases en pixels]
        lancer la spirale d'Ulam en interface graphique
        exemple :
        sh runGuiUlam.sh 200 1 5
        la grille fait 200x200 avec 1 comme valeur de départ de la spirale et les cases font 5x5 pixels

        - sh runGuiUlamDefault.sh
        execute sh runGuiUlam.sh 1901 1 1
    
    # Syracuse
    
        - sh runGuiSyracuseNumbers.sh [min] [max]
        lance l'interface du graphique en bar avec les nombres entre [min, max] avec 2<=min
        exemple:
        sh runGuiSyracuseNumbers.sh 2 100

        - sh runGuiSyracuseNumbers.sh [max]
        lance l'interface du graphique en bar avec les nombres entre [2, max]
        exemple:
        sh runGuiSyracuseNumbers.sh 150

        - sh runGuiSyracuseNumbersDefault.sh
        execute sh runGuiSyracuseNumbers.sh 100
        
        - sh runGuiSyracuseVariations.sh [nombre]
        lance l'interface sur le graphique des variations du nombre donné
        exemple:
        sh runGuiSyracuseVariations.sh 27
        
        - sh runGuiSyracuseVariationsDefault.sh
        execute sh runGuiSyracuseVariations.sh 97
        
        - sh runModelSyracuseNumbers.sh [max]
        donne la liste des nombres entre [2, max] avec leur nombre d'itérations
        exemple:
        sh runModelSyracuseNumbers.sh 200
        
        - sh runModelSyracuseNumbersDefault.sh
        execute sh runModelSyracuseNumbers.sh 100
        
        - sh runModelSyracuseVariations.sh [number]
        donne la liste de toutes les valeurs prises par le nombre dans la suite de Syracuse
        exemple:
        sh runModelSyracuseVariations.sh 97
        
        - sh runModelSyracuseVariationsDefault.sh
        execute sh runModelSyracuseVariations.sh 97
    
    # utilitaire
    
        - sh makedoc.sh
        créer la documentation de la partie java et la met dans java/doc/

        - sh compile.sh
        compile tout le code et le place dans build/

        - sh clean.sh
        supprime build/ et doc/