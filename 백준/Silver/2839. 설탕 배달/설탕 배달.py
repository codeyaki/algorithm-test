n = int(input())
for big in range(n//5, -1, -1) :
    if (n-big*5)%3 == 0 :
        small = (n-big*5)//3
        print(big+small)
        break
else : print(-1)