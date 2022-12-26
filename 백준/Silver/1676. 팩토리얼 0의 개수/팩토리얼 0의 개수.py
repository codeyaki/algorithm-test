#https://teching.tistory.com/

n = int(input())
fac = 1
for i in range(1,n+1):
    fac *= i
fac = str(fac)
answer = 0
for i in range(len(fac)-1,-1,-1):
    if fac[i] != '0': break
    answer += 1
print(answer)