import matplotlib.pyplot as plt

f=open("primaliteerasthotene.txt","r")

x=[]
y=[]
cpt=0
for l in f:
    point=l.split("=")
    x.append(point[0])
    y.append(point[1])
f.close()
print(x)
f=open("pr.csv","a")

s=""
for i in range(len(x)):
    s+=str(x[i]+";"+y[i])
    print(s)

f.write(s)
f.close()


"""
    cpt+=1
plt.plot(x,y)
plt.xticks(rotation=45)
plt.xlabel("temps en seconde")
plt.ylabel("limite")
plt.show()
"""
