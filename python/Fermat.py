from random import randint;
import sys
import os

def fermat(p):
    for i in range(5):
        a = randint(1,p-1);
        #if (a**(p-1)%p != 1):
        if (expo_modulaire(a,p-1,p) != 1):
            return False;
    return True;

def expo_modulaire(a,e,m):
    # => calcule (a**e)%m
    res = 1;
    while e>0:
        if e&1==0: # => e%2 == 1
            e = e>>1; # => e = e//2
        else:
            res = (res*a)%m;
            e = (e-1)>>1; # e = (e-1)//2
        a = (a*a)%m;
    return res;


"""
file : chemin d'un fichier de sauvegarde
limite : jusqu'a combien de nombre premier on veut


lancer plusieurs processus en meme temps
la parcelle sur laquelle on travaille/le nombre de processus que l'on veut lancer
numeroter les processus et rajouter les listes de retour en fonction de leur
numerotation
"""
def creaList(file,limite,limit_list_memory=1000000,debut=3,cpt_nombre_premier=0):

    if debut<=3:
        list_nombre_premier=[2]
    else:
        list_nombre_premier=[]

    if debut%2==0:
        debut+=1

    taille_tmp=0

    while cpt_nombre_premier<limite:
        if taille_tmp==limit_list_memory:
            print(cpt_nombre_premier//limit_list_memory)
            saveInFile(file,list_nombre_premier)
            list_nombre_premier=[]
            taille_tmp=0
        if fermat(debut):
            list_nombre_premier.append(debut)
            cpt_nombre_premier+=1
            taille_tmp+=1
        debut+=2
    saveInFile(file,list_nombre_premier)

def count(f):
    object_file=open(f,"r")
    cpt=0
    for ligne in object_file:
        cpt+=1
    return cpt

def saveInFile(file,liste):
    object_file=open(file,"a")
    for x in liste:
        object_file.write(str(x)+"\n")
    object_file.close()

def fusionFile(new_file,list_file=[]):
    object_file=open(new_file,"a")
    if list_file!=[]:
        for file in list_file:
            of=open(file,"r")
            for ligne in of:
                object_file.write(ligne)
            of.close()
    object_file.close()

def separate(file,newname="premierprime",ecart=1000000,limite_file=100):
    object_file=open(file,"r")
    cpt_ligne=0
    cpt_file=0
    tmp_list=[]

    for ligne in object_file:
        ligne=ligne.replace("\n","")
        if cpt_ligne==ecart:
            saveInFile(newname+str(cpt_file),tmp_list)
            tmp_list=[]
            cpt_file+=1
            cpt_ligne=0

        tmp_list.append(ligne)
        cpt_ligne+=1
        if cpt_file==limite_file:
            break

def fermatList(l):
    f=[]
    for p in l:
        t=fermat(p)
        print(p)
        if not t:
            f.append(p)
    return f

def parser(f):
    l=[]
    a=open(f,"r")
    for ligne in a:
        l.append(int(ligne))
    return l


def main():
    #print(fermat(9999991)); #(9 999 991 est premier)
    #print(expo_modulaire(421,600-1,600));

    #print(fermatList(parser("premier")))
    #print(count("premier"))
    file_name="premierprime"
    #fusionFile(file_name,list_file=["premierprime1","premierprime2"])

    #creaList(file_name,100000,limit_list_memory=1000,debut=3)
    fusionFile(file_name,["a/"+x for x in os.listdir("a/")])
    #separate(file_name,newname="a/"+file_name,limite_file=3)

main()
