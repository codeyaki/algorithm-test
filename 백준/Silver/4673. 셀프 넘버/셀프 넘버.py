def d(n) :
    return n+sum(map(int,str(n)))
selfNum = []
for i in range(10000) :
    selfNum.append(d(i))
    if not i in selfNum :
        print(i)