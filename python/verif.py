from scipy.interpolate import lagrange
from numpy.polynomial.polynomial import Polynomial
import Fermat
import numpy as np


x = np.array([0, 1, 2])
y = [41,43,47]

poly = lagrange(x, y)
a = Polynomial(poly).coef

print(a)
liste=[]
cpt=0
dcpt=[]
for i in range(1000):
    res=int(poly(i))
    if res>1:
        if Fermat.fermat(res):

            liste.append(res)
            cpt+=1

        else:

            if len(liste)>0:
                dcpt.append(liste)

            cpt=0
            liste=[]
    else:
        if len(liste)>0:
            dcpt.append(liste)

        cpt=0
        liste=[]

k=0
m=[]

while k<len(dcpt):
    if len(dcpt[k])>len(m):
        m=dcpt[k]
    k+=1
print(len(m))
print(m)

f=[]
for j in range(42,1602):
    if Fermat.fermat(j):
        f.append(j)
print(len(f))
print(f)
