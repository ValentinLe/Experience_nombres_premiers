x=[3 nombres premiers]
y=[0,1,2]
liste=[]
polynome=lagrange(x,y)
for i in range(1000):
  if fermat(polynome(i)):
    liste=polynome(i)
  else:
    liste=[]
