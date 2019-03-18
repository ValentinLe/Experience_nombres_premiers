from scipy.interpolate import lagrange
from numpy.polynomial.polynomial import Polynomial
import Fermat
import numpy as np
import json

def parser(f,l=1000):
    l=[]
    cpt=1
    a=open(f,"r")
    for ligne in a:
        if cpt<=l:
            l.append(int(ligne))
        else:
            break
        cpt+=1
    a.close()
    return l


l=1000
p=parser("",l)

d={}
x = np.array([0, 1, 2])
for i in range(l-3):
    #interpolate
    y=[p[0+i],p[1+i],p[2+i]]
    poly = lagrange(x, y)
    a = Polynomial(poly).coef
    #test
    s=str(y[0])+";"+str(y[1])+";"+str(y[2])
    cpt=0
    d1={}
    for i in range(100):
        if Fermat.feramt(a[0]*(i**2)+a[1]*i+a[2]):
            d1[str(i)]=a[0]*(i**2)+a[1]*i+a[2]
    d[s]=d1

print(d)
"""
f=open("gen.txt","a")
json.dump(d,f)
f.close()
"""
