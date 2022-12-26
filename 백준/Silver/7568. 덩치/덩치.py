import sys
peoples = []
for _ in range(int(sys.stdin.readline())) :
    peoples.append(list(map(int,sys.stdin.readline().split())))
for i in peoples:
    k = 0
    for j in peoples:
        if i[0] < j[0] and i[1] < j[1]: k += 1
    print(k+1, end = " ")