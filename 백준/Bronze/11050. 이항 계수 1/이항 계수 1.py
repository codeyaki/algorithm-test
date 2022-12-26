#https://teching.tistory.com/

n, k = map(int, input().split())
fac = [1]*(n+1)
if 0 <= k and k <= n:
    for i in range(1,n+1):
        fac[i] = fac[i-1]*(i)
    print(fac[n]//(fac[k]*fac[n-k]))
else:
    print(0)