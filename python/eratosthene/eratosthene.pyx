
cdef int limite=111000


cpdef primaliteEratosthene(int limite)
  liste=[]
  cdef int i
  for i in range(3, limite, 2):
    liste.append(i)

  cdef int listelongueur=len(liste)

  liste_tmp=[]
  listepremier=[2]


  while listelongueur!=1:

      cdef int compteur=liste[0]
      listepremier.append(compteur)
      cdef int i
      for i in range(1,listelongueur):
          if liste[i]%compteur!=0:
              liste_tmp.append(liste[i])
      liste=liste_tmp
      liste_tmp=[]
      listelongueur=len(liste)
