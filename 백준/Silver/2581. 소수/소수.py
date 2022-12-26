m = int(input())
n = int(input())
answer =[]
for num in range(m,n+1) :
    if num == 1 : continue
    for i in range(2,int(num**.5)+1) :
        if num%i == 0 : break
    else : answer.append(num)
if answer == [] : print(-1)
else :
    print(sum(answer))
    print(min(answer))