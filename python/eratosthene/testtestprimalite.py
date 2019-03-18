import time

f=open("primaliteerasthotene.txt","w")

n=5000
essaye=20

limite=1000

liste_essaye={}

for i in range(1,n):
    print(i)
    limite=1000*i
    liste_essaye[limite]=0

    for j in range(essaye):
        start = time.time()

        liste=[]
        for i in range(1, limite, 2):
            liste.append(i)
        del liste[0]

        listelongueur=len(liste)

        listep=[]

        listepremier=[2]
        while listelongueur!=1:
            compteur=liste[0]
            listepremier.append(liste[0])
            for i in range(1,listelongueur):
                if liste[i]%compteur!=0:
                    listep.append(liste[i])
            liste=listep
            listep=[]
            listelongueur=len(liste)

        end = time.time()
        t=end-start
        liste_essaye[limite]+=t

    liste_essaye[limite]/=essaye
    f.write(""+str(limite)+"="+str(liste_essaye[limite])+"\n")

f.close()
print(liste_essaye)
