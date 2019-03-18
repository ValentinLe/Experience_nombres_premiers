
cdef int limite=500000000
def eratosthene(int limite):
    liste=[]
    cdef int i
    for i in range(3, limite, 2):
        liste.append(i)

    listelongueur=len(liste)

    liste_tmp=[]

    listepremier=[2]

    while listelongueur!=1:
        compteur=liste[0]
        listepremier.append(compteur)
        for i in range(1,listelongueur):
            if liste[i]%compteur!=0:
                liste_tmp.append(liste[i])
        liste=liste_tmp
        liste_tmp=[]
        listelongueur=len(liste)
    return listepremier

print(eratosthene(limite))
