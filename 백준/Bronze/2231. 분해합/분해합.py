n = int(input())
for i in range(n) :
    if n == i + sum([int(i) for i in str(i)]) :
        print(i)
        break
else : print(0)