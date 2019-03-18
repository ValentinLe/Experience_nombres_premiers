import numpy

limite=580000000

liste=[]
# on remplie une liste qui tous les chiffre impair jusqu'a limite
for i in range(3, limite, 2):
    liste.append(i)

listelongueur=len(liste)

liste_tmp=[]

listepremier=[2]
"""
perc=(100*listelongueur)/limite
print(perc)
"""

fo = open("premier.txt","w")
fo.write("2\n")
while listelongueur!=1:
    """
    p1=(100*listelongueur)/limite
    if p1!=perc:
        perc=p1
        print(perc)
    """
    compteur=liste[0]
    # on ajoute le nombre premier qui se trouve au debut de la liste
    # a nombre premier
    listepremier.append(compteur)
    fo.write(listepremier[-1]+"\n")
    for i in range(1,listelongueur):
        if liste[i]%compteur!=0:
            liste_tmp.append(liste[i])
    liste=liste_tmp
    liste_tmp=[]
    listelongueur=len(liste)

print(listepremier)

# pour une limite de 100000
# execution time : 12.399 s
# execution time : 12.978 s

# pour une limite de 110000
# execution time : 14.881 s

# pour une limite de 111000
# execution time : 15.174 s
# execution time : 15.548 s
# execution time : 15.428 s

# pour une limite de 200000
# execution time : 50.955 s
# execution time : 50.793 s

# pour une limite de 400000 un temps de calcule de
# execution time : 209.478 s
