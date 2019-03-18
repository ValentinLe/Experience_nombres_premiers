from time import *
import matplotlib.pyplot as plt

def mersenne_search(file, bound):   
    res=[]
    for i in range(1, bound):
        test = (2**i)-1
        if primescan(file,test):
            res.append(test)
    return res      

def lucas_test(p):
    m=(2**p)-1
    s=lucas_sequence(p-2)
    return s%m==0

def lucas_sequence(i):
    if i==0:
        return 4
    return (lucas_sequence(i-1)**2)-2


def primescan(file, nb):
    f=open(file,"r")
    for line in f:
        if line.strip("\nluudd") == str(nb):
            f.close()
            return True
    f.close()
    return False

#print(mersenne_search("premierprime",32))
t = []
term = []
for i in range(3, 32):
    ts = time()
    print(lucas_test(i))
    t.append(time()-ts)
    term.append(i)

plt.plot(term,time)
plt.title("Temps de calcul du test de Lucas-Lehmer")
plt.xlabel("Terme")
plt.ylabel("Temps")
